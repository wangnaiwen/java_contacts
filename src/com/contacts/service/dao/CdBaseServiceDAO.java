package com.contacts.service.dao;

import com.contacts.dao.impl.CdDAO;

public class CdBaseServiceDAO {
	private CdDAO cdDAO;

	public CdDAO getCdDAO() {
		return cdDAO;
	}

	public void setCdDAO(CdDAO cdDAO) {
		this.cdDAO = cdDAO;
	}
	
}
