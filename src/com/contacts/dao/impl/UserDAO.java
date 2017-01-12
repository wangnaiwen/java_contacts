package com.contacts.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.IUserDAO;
import com.contacts.domain.User;

public class UserDAO extends BaseDAO implements IUserDAO{

	public User validateUser(String phone, String password) {
		String sql = "from User u where u.phone='"+phone+"' and u.password='" + password + "'";
		
		Session session = getSession();

		Query query = session.createQuery(sql);
		
		List<User> users = query.list();
		if(users.size() != 0){
			User user = (User)users.get(0);
			session.close();
			return user;
		}
		session.close();
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public User selectUserById(int id) {
		
		String sql = "from User u where u.id="  + id;
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<User> users = query.list();
		if(users.size() != 0){
			User user = (User)users.get(0);
			session.close();
			return user;
		}
		session.close();
		return null;
	}

	@Override
	public User selectUserByPhone(String phone) {
		String sql = "from User u where u.phone='"  + phone + "'";
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<User> users = query.list();
		if(users.size() != 0){
			User user = (User)users.get(0);
			session.close();
			return user;
		}
		session.close();
		return null;
	}	
	
	
}
