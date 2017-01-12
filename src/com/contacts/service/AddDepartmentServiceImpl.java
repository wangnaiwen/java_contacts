package com.contacts.service;

import com.contacts.dao.impl.DepartmentDAO;
import com.contacts.domain.Department;
import com.contacts.service.dao.AddDepartmentServiceDAO;
import com.contacts.service.dao.DepartmentBaseServiceDAO;

public class AddDepartmentServiceImpl extends DepartmentBaseServiceDAO implements AddDepartmentServiceDAO {

	@Override
	public boolean addDepartment(Department department) {
		DepartmentDAO departmentDAO = getDepartmentDAO();
		return departmentDAO.insertDepartment(department);
	}
}
