package com.contacts.service;

import com.contacts.dao.impl.CompanyDAO;
import com.contacts.domain.Company;
import com.contacts.service.dao.CompanyBaseServiceDAO;
import com.contacts.service.dao.RegisterCompanyServiceDAO;

public class RegisterCompanyServiceImpl extends CompanyBaseServiceDAO implements RegisterCompanyServiceDAO{
	public boolean registerCompany(Company company){
		CompanyDAO companyDAO = getCompanyDAO();
		companyDAO.insertCompany(company);
		return true;
	}
}
