package com.contacts.service.dao;

import com.contacts.domain.User;

public interface SelectUserServiceByIdDAO {
	public User selectUserById(int id);
}
