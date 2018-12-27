package com.org.app.aop;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {
	@Around("within(@org.springframework.stereotype.Controller *)")
    public Object ctrlAspect(ProceedingJoinPoint jp) throws Throwable {
		HttpServletRequest req = null;
		HttpSession session = null;
		MethodSignature signature = (MethodSignature)jp.getSignature();
		String method = signature.getMethod().getName();
		String[] exceptMethodArray = {"login", "loginOk", "signOn", "dupleIdCheck", "signOnNew", "forgotId"};
		
		System.out.println("method="+method);
		System.out.println("indedOf="+Arrays.asList(exceptMethodArray).indexOf(method));
		if (Arrays.asList(exceptMethodArray).indexOf(method) < 0) {
			Object[] ob = jp.getArgs();
			for (Object obj : ob) {
				System.out.println(obj instanceof HttpServletRequest);
				if (obj instanceof HttpServletRequest) {
					req = (HttpServletRequest)obj;
					session = req.getSession();
					if (session.getAttribute("NAME") != null && !session.getAttribute("NAME").equals("")) {
						return jp.proceed();
					} else {
						//loop
					}
				}
			}
		} else {
			return jp.proceed();
		}
		
		return null;//"/main/login";
    }
	
	/*@Around("within(@org.springframework.stereotype.Service *)")
    public Object serviceAspect(ProceedingJoinPoint jp) throws Throwable {
		return jp.proceed();
	}*/
}
