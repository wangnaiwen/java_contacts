package com.contacts.dao;

import com.contacts.domain.Company;


public interface ICompanyDAO {
	public boolean insertCompany(Company company);
	public boolean deleteCompany(Company company);
	public boolean updateCompany(Company company);
	public Company selectCompanyById(int id);
	/*public List<Company> selectCompanyByUserId(int userId);
	public List<Department> selectCompanyById(int id);
	public boolean addUserToCompany(int id,int departId,User user);*/
}
