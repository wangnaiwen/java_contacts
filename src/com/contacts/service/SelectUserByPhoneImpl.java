package com.contacts.service;

import com.contacts.dao.impl.UserDAO;
import com.contacts.domain.User;
import com.contacts.service.dao.BaseServiceDAO;
import com.contacts.service.dao.SelectUserByPhoneDAO;

public class SelectUserByPhoneImpl extends BaseServiceDAO implements SelectUserByPhoneDAO {

	@Override
	public User SelectUserByPhone(String phone) {
		UserDAO userDAO = getUserDAO();
		return userDAO.selectUserByPhone(phone);
	}

}
