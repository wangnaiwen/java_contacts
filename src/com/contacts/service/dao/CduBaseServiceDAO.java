package com.contacts.service.dao;

import com.contacts.dao.impl.CduDAO;

public class CduBaseServiceDAO {
	private CduDAO cduDAO;

	public void setCduDAO(CduDAO cduDAO) {
		this.cduDAO = cduDAO;
	}

	public CduDAO getCduDAO() {
		return cduDAO;
	}
	
}
