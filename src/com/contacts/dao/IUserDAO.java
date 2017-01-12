package com.contacts.dao;

import com.contacts.domain.User;


public interface IUserDAO {
	public User validateUser(String phone, String password);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public User selectUserById(int id);
	public User selectUserByPhone(String phone);
}
