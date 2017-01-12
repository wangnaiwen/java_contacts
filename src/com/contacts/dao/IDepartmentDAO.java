package com.contacts.dao;


import com.contacts.domain.Department;

public interface IDepartmentDAO {
	public boolean insertDepartment(Department department);
	public boolean deleteDepartment(Department department);
	public boolean updateDepartment(Department department);
	public Department selectDepartmentById(int id);
	public Department selectDepartmentByName(String name);
}
