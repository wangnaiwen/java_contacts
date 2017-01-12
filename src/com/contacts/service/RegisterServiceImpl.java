package com.contacts.service;

import com.contacts.dao.impl.UserDAO;
import com.contacts.domain.User;
import com.contacts.service.dao.BaseServiceDAO;
import com.contacts.service.dao.RegisterServiceDAO;

public class RegisterServiceImpl extends BaseServiceDAO implements RegisterServiceDAO{
	
	@Override
	public boolean register(User user) {
		UserDAO userDAO = getUserDAO();
		return userDAO.insertUser(user);
	}
	
}
