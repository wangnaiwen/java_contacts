package com.contacts.service;

import com.contacts.dao.impl.UserDAO;
import com.contacts.domain.User;
import com.contacts.service.dao.BaseServiceDAO;
import com.contacts.service.dao.SelectUserServiceByIdDAO;

public class SelectUserByIdServiceImpl extends BaseServiceDAO implements SelectUserServiceByIdDAO{

	@Override
	public User selectUserById(int id) {
		UserDAO userDAO = getUserDAO();
		return userDAO.selectUserById(id);
	}
}
