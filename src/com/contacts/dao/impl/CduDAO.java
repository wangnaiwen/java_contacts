package com.contacts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.ICduDAO;
import com.contacts.domain.Cdu;

public class CduDAO extends BaseDAO implements ICduDAO{

	@Override
	public boolean insertCdu(Cdu cdu) {
		//System.out.println(cd.getId().getCompany().getId() + " " + cd.getId().getDepartment().getId());
		Transaction transaction = null;
		try{
			
			Session session = getSession();
			transaction = session.beginTransaction();
			session.save(cdu);
			session.close();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCdu(Cdu cdu) {
		Transaction transaction = null;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			session.update(cdu);
			session.close();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCdu(Cdu cdu) {
		Session session = getSession();
		session.delete(cdu);
		return true;
	}

	@Override
	public List<Cdu> selectCduBycId(int cId) {
		String sql = "from Cdu where cid=" + cId;
		Session session = getSession();
		Query query = session.createQuery(sql);
		List<Cdu> cdus = query.list();
		session.close();
		return cdus;
	}

	@Override
	public List<Cdu> selectCduByuId(int uId) {
		System.out.println(uId);
		String sql = "from Cdu where uid=" + uId;
		Session session = getSession();
		Query query = session.createQuery(sql);
		List<Cdu> cdus = query.list();
		session.close();
		return cdus;
	}	
}
