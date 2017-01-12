package com.contacts.service.dao;

import com.contacts.domain.User;

public interface SelectUserByPhoneDAO {
	public User SelectUserByPhone(String phone);
}
