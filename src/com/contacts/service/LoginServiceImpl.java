package com.contacts.service;

import com.contacts.dao.impl.UserDAO;
import com.contacts.domain.User;
import com.contacts.service.dao.BaseServiceDAO;
import com.contacts.service.dao.LoginServiceDAO;

public class LoginServiceImpl extends BaseServiceDAO implements LoginServiceDAO{

	@Override
	public User login(String phone, String password) {
		UserDAO userDAO = getUserDAO();
		User user = userDAO.validateUser(phone, password);
		return user;
	}
	
}
