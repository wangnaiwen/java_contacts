package com.contacts.service;

import com.contacts.dao.impl.CompanyDAO;
import com.contacts.domain.Company;
import com.contacts.service.dao.CompanyBaseServiceDAO;
import com.contacts.service.dao.SelectCompanyByIdDAO;

public class SelectCompanyByIdImpl extends CompanyBaseServiceDAO implements SelectCompanyByIdDAO{

	@Override
	public Company selectCompanyById(int id) {
		CompanyDAO companyDAO = getCompanyDAO();
		return companyDAO.selectCompanyById(id);
	}
	
}
