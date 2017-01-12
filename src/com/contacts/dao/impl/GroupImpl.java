package com.contacts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.GroupDAO;
import com.contacts.domain.Grouping;

public class GroupImpl extends BaseDAO implements GroupDAO{

	@Override
	public boolean insertGroup(Grouping group) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			
			transaction = session.beginTransaction();
			session.save(group);
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
	public boolean deleteGroup(Grouping group) {
		Session session = getSession();
		session.delete(group);
		session.close();
		return true;
	}

	@Override
	public boolean updateGroup(Grouping group) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			session.update(group);
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
	public Grouping selectGroupById(int id) {

		String sql = "from Grouping g where g.id="  + id;
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Grouping> groups = query.list();
		if(groups.size() != 0){
			Grouping group = (Grouping)groups.get(0);
			session.close();
			return group;
		}
		session.close();
		return null;
	}

	@Override
	public Grouping selectGroupByName(String name) {
		String sql = "from Grouping g where g.name='"  + name +"'";
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Grouping> groups = query.list();
		if(groups.size() != 0){
			Grouping group = (Grouping)groups.get(0);
			session.close();
			return group;
		}
		session.close();
		return null;	
	}

	@Override
	public List<Grouping> selectGroupByUserId(int userId) {
		String sql = "select * from grouping where userid=" + userId;
		
		Session session = getSession();

		List<Grouping> groups = session.createSQLQuery(sql).addEntity(Grouping.class).list();
		
		if(groups.size() != 0){
			session.close();
			return groups;
		}
		
		session.close();
		return null;
	}

	@Override
	public boolean deleteGroupByUserId(int userId) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			String sql = "select * from grouping where userid=" + userId;

			transaction = session.beginTransaction();
			List<Grouping> groups = session.createSQLQuery(sql).addEntity(Grouping.class).list();
			
			if(groups.size() != 0){
				int length = groups.size();
				for(int i = 0 ; i < length; i++){
					session.delete(groups.get(i));
				}	
			}		
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
}
