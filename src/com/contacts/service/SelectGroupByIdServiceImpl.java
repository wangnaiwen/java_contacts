package com.contacts.service;

import com.contacts.dao.GroupDAO;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.GroupBaseServiceDAO;
import com.contacts.service.dao.SelectGroupByIdServiceDAO;

public class SelectGroupByIdServiceImpl extends GroupBaseServiceDAO implements SelectGroupByIdServiceDAO{

	@Override
	public Grouping selectGroupById(int id) {
		GroupDAO groupDAO = getGroupDAO();
		return groupDAO.selectGroupById(id);
	}
	
}
