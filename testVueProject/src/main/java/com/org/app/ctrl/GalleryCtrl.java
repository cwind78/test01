package com.org.app.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryCtrl {

	@GetMapping("/gallery") // 
	public String galleryPop(HttpServletRequest request) {
		return "board/gallery";
	}
}
