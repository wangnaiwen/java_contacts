package com.contacts.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.ICompanyDAO;
import com.contacts.domain.Company;
import com.contacts.domain.User;

public class CompanyDAO extends BaseDAO implements ICompanyDAO{

	@Override
	public boolean insertCompany(Company company) {
		Transaction transaction = null;
		try{
			
			Session session = getSession();
			transaction = session.beginTransaction();
			session.save(company);
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
	public boolean deleteCompany(Company company) {
		Session session = getSession();
		session.delete(company);
		session.close();
		return false;
	}

	@Override
	public boolean updateCompany(Company company) {
		Transaction transaction = null;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			session.update(company);
			session.close();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}
/*
	@Override
	public List<Company> selectCompanyByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> selectCompanyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserToCompany(int id, int departId, User user) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public Company selectCompanyById(int id) {
		Session session = getSession();
		String sql = "from Company c where c.id=" + id;
		Query query = session.createQuery(sql);

		List<Company> companies = query.list();
		if(companies.size() != 0){
			Company company = (Company)companies.get(0);
			return company;
		}
		session.close();
		return null;
	}

}
