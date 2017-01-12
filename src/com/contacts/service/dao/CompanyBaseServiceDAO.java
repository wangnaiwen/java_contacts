package com.contacts.service.dao;

import com.contacts.dao.impl.CompanyDAO;

public class CompanyBaseServiceDAO {
	private CompanyDAO companyDAO;

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
}
