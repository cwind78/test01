package com.org.app.mapper;

import java.util.List;
import com.org.app.vo.User;

public interface UserDao {
	public List<User> loginOk(User user) throws Exception;
	public List<User> dupleIdCheck(User user) throws Exception;
	public Integer signOnNew(User user) throws Exception;
}
