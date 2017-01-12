package com.contacts.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contacts.dao.BaseDAO;
import com.contacts.dao.IDepartmentDAO;
import com.contacts.domain.Department;
import com.contacts.domain.User;

public class DepartmentDAO extends BaseDAO implements IDepartmentDAO{

	@Override
	public boolean insertDepartment(Department department) {
		Transaction transaction = null;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			session.save(department);
			session.clear();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDepartment(Department department) {
		Session session = getSession();
		session.delete(department);
		session.clear();
		return true;
	}

	@Override
	public boolean updateDepartment(Department department) {
		Transaction transaction = null;
		try{
			Session session = getSession();
			transaction = session.beginTransaction();
			session.update(department);
			session.clear();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public Department selectDepartmentById(int id) {
		String sql = "from Department d where d.id="  + id;
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Department> departments = query.list();
		if(departments.size() != 0){
			System.out.println("This is DepartmentDAO");
			Department department = (Department)departments.get(0);
			return department;
		}
		session.close();
		return null;
	}

	@Override
	public Department selectDepartmentByName(String name) {
    String sql = "from Department d where d.name='"  + name + "'";
		
		Session session = getSession();

		Query query = session.createQuery(sql);

		List<Department> departments = query.list();
		if(departments.size() != 0){
			System.out.println("This is DepartmentDAO");
			Department department = (Department)departments.get(0);
			return department;
		}
		session.close();
		return null;
	}

	
}
