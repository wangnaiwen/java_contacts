package com.contacts.service.dao;

import java.util.List;

import com.contacts.domain.Cdu;


public interface SelectCompanyByUserServiceDAO {
	public List<Cdu> selectCompanyByUser(int uid);
}
