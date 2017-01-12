package com.contacts.service.dao;

import com.contacts.dao.impl.UserDAO;

public class BaseServiceDAO {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
}
