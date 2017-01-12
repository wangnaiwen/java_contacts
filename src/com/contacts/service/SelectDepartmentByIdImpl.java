package com.contacts.service;

import com.contacts.dao.impl.DepartmentDAO;
import com.contacts.domain.Department;
import com.contacts.service.dao.DepartmentBaseServiceDAO;
import com.contacts.service.dao.SelectDepartmentByIdDAO;

public class SelectDepartmentByIdImpl extends DepartmentBaseServiceDAO implements SelectDepartmentByIdDAO{

	@Override
	public Department selectDepartmentById(int id) {
		DepartmentDAO departmentDAO = getDepartmentDAO();
		return departmentDAO.selectDepartmentById(id);
	}

}
