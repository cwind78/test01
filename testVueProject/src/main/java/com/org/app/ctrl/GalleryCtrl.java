package com.org.app.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryCtrl {

	@GetMapping("/gallery") // 
	public String login() {
		return "board/gallery";
	}
}
