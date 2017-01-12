package com.contacts.service;

import com.contacts.dao.impl.CdDAO;
import com.contacts.domain.Cd;
import com.contacts.service.dao.CdBaseServiceDAO;
import com.contacts.service.dao.InsertCdServiceDAO;

public class InsertCdImpl extends CdBaseServiceDAO implements InsertCdServiceDAO{

	@Override
	public boolean insertCd(Cd cd) {
		CdDAO cdDAO = getCdDAO();
		return cdDAO.insertCd(cd);
	}
}
