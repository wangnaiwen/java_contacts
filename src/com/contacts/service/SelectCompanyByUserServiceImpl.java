package com.contacts.service;

import java.util.List;

import com.contacts.dao.impl.CduDAO;
import com.contacts.domain.Cdu;
import com.contacts.service.dao.CduBaseServiceDAO;
import com.contacts.service.dao.SelectCompanyByUserServiceDAO;

public class SelectCompanyByUserServiceImpl extends CduBaseServiceDAO implements SelectCompanyByUserServiceDAO{

	@Override
	public List<Cdu> selectCompanyByUser(int uid) {
		CduDAO cduDAO = getCduDAO();
		return cduDAO.selectCduByuId(uid);
	}

}
