package com.sanbao.it.service.impl;

import com.sanbao.it.DAO.UserDAO;
import com.sanbao.it.DAO.impl.UserDAOImpl;
import com.sanbao.it.ORM.User;
import com.sanbao.it.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String user_id) {
		UserDAO ud = new UserDAOImpl();
		User user = ud.getUser(user_id);
		return user;
	}

}
