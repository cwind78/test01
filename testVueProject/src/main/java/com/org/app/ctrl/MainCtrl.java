package com.org.app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {
	@GetMapping("/main") // 
	public String login() {
		return "main/main";
	}
}
