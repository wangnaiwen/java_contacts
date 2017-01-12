package com.contacts.service;

import com.contacts.dao.impl.DepartmentDAO;
import com.contacts.domain.Department;
import com.contacts.service.dao.DepartmentBaseServiceDAO;
import com.contacts.service.dao.SelectDepartmentByNameDAO;

public class SelectDepartmentByNameImpl extends DepartmentBaseServiceDAO implements SelectDepartmentByNameDAO{

	@Override
	public Department selectDepartmentByName(String name) {
		DepartmentDAO departmentDAO = getDepartmentDAO();
		return departmentDAO.selectDepartmentByName(name);
	}

}
