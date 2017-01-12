package com.contacts.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.ICdDAO;
import com.contacts.domain.Cd;

public class CdDAO extends BaseDAO implements ICdDAO{

	@Override
	public boolean insertCd(Cd cd) {
		System.out.println(cd.getId().getCompany().getId() + " " + cd.getId().getDepartment().getId());
		Transaction transaction = null;
		try{
			
			Session session = getSession();
			transaction = session.beginTransaction();
			session.save(cd);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean deleteCd(Cd cd) {
		Session session = getSession();
		session.delete(cd);
		session.close();
		return true;
	}

	@Override
	public boolean updateC(Cd cd) {
		Transaction transaction = null;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			session.update(cd);
			session.close();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}
	
}
