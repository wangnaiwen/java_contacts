package com.contacts.service;

import com.contacts.dao.GroupDAO;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.GroupBaseServiceDAO;
import com.contacts.service.dao.SelectGroupByNameServiceDAO;

public class SelectGroupByNameServiceImpl extends GroupBaseServiceDAO implements SelectGroupByNameServiceDAO{

	@Override
	public Grouping selectGroupByName(String name) {
		GroupDAO groupDAO = getGroupDAO();
		return groupDAO.selectGroupByName(name);
	}
	
}
