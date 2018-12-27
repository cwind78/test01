package com.org.app.mapper;

import java.util.List;
import com.org.app.vo.Menu;

public interface MenuDao {
	public List<Menu> getRootMenu() throws Exception;
}
