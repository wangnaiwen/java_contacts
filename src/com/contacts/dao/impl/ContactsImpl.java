package com.contacts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.ContactsDAO;
import com.contacts.domain.Contacts;

public class ContactsImpl extends BaseDAO implements ContactsDAO {

	@Override
	public boolean insertContacts(Contacts contacts) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			session.save(contacts);
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
	public boolean updateContacts(Contacts contacts) {
		Transaction transaction = null;
		Session session = getSession();
		try{
			transaction = session.beginTransaction();
			session.update(contacts);
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
	public Contacts selectContactsById(int id) {
		String sql = "from Contacts c where c.id="  + id;
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Contacts> cList = query.list();
		if(cList.size() != 0){
			Contacts contacts = (Contacts)cList.get(0);
			session.close();
			return contacts;
		}
		session.close();
		return null;
	}

	@Override
	public Contacts selectContactsByPhone(String phone) {
		String sql = "from Contacts c where c.phone='"  + phone + "'";
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Contacts> cList = query.list();
		if(cList.size() != 0){
			Contacts contacts = (Contacts)cList.get(0);
			session.close();
			return contacts;
		}
		session.close();
		return null;
	}

	@Override
	public boolean deleteContacts(Contacts contacts) {
		Session session = getSession();
		session.delete(contacts);
		session.close();
		return true;
	}

	@Override
	public List<Contacts> selectContactsByGroupId(int groupId) {
		String sql = "select * from contacts where groupid="  + groupId;
		
		Session session = getSession();

		Query query = session.createSQLQuery(sql).addEntity(Contacts.class);

		List<Contacts> cList = query.list();
		if(cList.size() != 0){
			session.close();
			return cList;
		}
		session.close();
		return null;
	}	
}
