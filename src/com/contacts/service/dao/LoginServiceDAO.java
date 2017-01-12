package com.contacts.service.dao;

import com.contacts.domain.User;

public interface LoginServiceDAO {
	User login(String phone, String password);
}

