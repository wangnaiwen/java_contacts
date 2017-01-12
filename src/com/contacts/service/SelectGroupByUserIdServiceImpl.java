package com.contacts.service;

import java.util.List;

import com.contacts.dao.GroupDAO;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.GroupBaseServiceDAO;
import com.contacts.service.dao.SelectGroupByUserIdServiceDAO;

public class SelectGroupByUserIdServiceImpl extends GroupBaseServiceDAO implements SelectGroupByUserIdServiceDAO{

	@Override
	public List<Grouping> selectGroupByUserId(int userId) {
		GroupDAO groupDAO = getGroupDAO();
		return groupDAO.selectGroupByUserId(userId);
	}

}
