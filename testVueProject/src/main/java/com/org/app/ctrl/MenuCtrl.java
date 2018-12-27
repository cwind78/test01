package com.org.app.ctrl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.org.app.mapper.MenuDao;
import com.org.app.vo.Menu;

@Controller
public class MenuCtrl {
	@Autowired
	MenuDao dao;
	
	@GetMapping("/menu_tree")
	@ResponseBody
	public List<Menu> getRootMenu(HttpServletRequest request) throws Exception {
		return dao.getRootMenu();
	}
}
