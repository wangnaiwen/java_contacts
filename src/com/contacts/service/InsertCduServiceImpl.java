package com.contacts.service;

import com.contacts.dao.impl.CduDAO;
import com.contacts.domain.Cdu;
import com.contacts.service.dao.CduBaseServiceDAO;
import com.contacts.service.dao.InsertCduServiceDAO;

public class InsertCduServiceImpl extends CduBaseServiceDAO implements InsertCduServiceDAO{

	@Override
	public boolean insertCdu(Cdu cdu) {
		CduDAO cduDAO = getCduDAO();
		return cduDAO.insertCdu(cdu);	 
	}

}
