package com.org.app.ctrl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.org.app.mapper.UserDao;
import com.org.app.vo.Result;
import com.org.app.vo.User;

@Controller
public class UserCtrl {
	@Autowired
	UserDao dao;
	
	@GetMapping("/login") // 
	public String login() {
		return "index";
	}
	
	@GetMapping("/sign_on") // 
	public String signOn() {
		return "user/sign_on";
	}
	
	@GetMapping("/forgot_id") // 
	public String forgotId() {
		return "user/forgot_id";
	}
	
	@GetMapping("/loginOk") // requestmapping method=RequestMethod.GET가 포함되어 있다.
    @ResponseBody
	public List<User> loginOk(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="pwd", required=true) String pwd,
			HttpServletRequest request) throws Exception {//aop session 체크를 위해서 ctrl 클래스의 모든 메써드는 HttpServletRequest argument를 가지고 있어야 한다
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		
		List<User> list = dao.loginOk(user);
		if (list != null && list.size() > 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("ID", user.getId());
			session.setAttribute("NAME", list.get(0).getName());
			session.setMaxInactiveInterval(60*120);
		}
		return list;
	}
	
	@GetMapping("/duple_id_check")
	@ResponseBody
	public List<User> dupleIdCheck(@RequestParam(value="id", required=true) String id, HttpServletRequest request) throws Exception {
		User user = new User();
		user.setId(id);
	
		return dao.dupleIdCheck(user);
	}
	
	@PostMapping("/sign_on_new")
	@ResponseBody
	public List<Result> signOnNew(@RequestBody User user, HttpServletRequest request) throws Exception {
		Result result = new Result();
		result.setResult(String.valueOf(dao.signOnNew(user)));
		result.setMessage(result.getResult().equals("1")?"success":"error");
		List<Result> list = new ArrayList<Result>();
		list.add(result);
		return list;
	}
	
	@GetMapping("/forgot_id/{name}")
	@ResponseBody
	public List<User> getForgotIdByName(@PathVariable("name") String name, HttpServletRequest request) throws Exception {
		User user = new User();
		user.setName(name);
		return dao.getForgotIdByName(user);
	}
	
	@PostMapping("/forgot_password")
	@ResponseBody
	public List<Result> initPassword(@RequestBody User user, HttpServletRequest request) throws Exception {
		Result result = new Result();
		result.setResult(String.valueOf(dao.initPassword(user)));
		result.setMessage(result.getResult().equals("1")?"success":"error");
		List<Result> list = new ArrayList<Result>();
		list.add(result);
		return list;
	}
}
