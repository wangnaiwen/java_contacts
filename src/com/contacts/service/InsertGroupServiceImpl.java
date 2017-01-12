package com.contacts.service;

import com.contacts.dao.GroupDAO;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.GroupBaseServiceDAO;
import com.contacts.service.dao.InsertGroupServiceDAO;

public class InsertGroupServiceImpl extends GroupBaseServiceDAO implements InsertGroupServiceDAO{

	@Override
	public boolean insertGroup(Grouping group) {
		GroupDAO groupDA = getGroupDAO();
		return groupDA.insertGroup(group);
	}

}
