package com.contacts.service.dao;

import com.contacts.dao.impl.DepartmentDAO;

public class DepartmentBaseServiceDAO {
	private DepartmentDAO departmentDAO;

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
}
