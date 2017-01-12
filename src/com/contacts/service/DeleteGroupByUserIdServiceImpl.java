package com.contacts.service;

import com.contacts.dao.GroupDAO;
import com.contacts.service.dao.DeleteGroupByUserIdServiceDAO;
import com.contacts.service.dao.GroupBaseServiceDAO;

public class DeleteGroupByUserIdServiceImpl extends GroupBaseServiceDAO implements DeleteGroupByUserIdServiceDAO{

	@Override
	public boolean deleteGroupByUserId(int userId) {
		GroupDAO groupDAO = getGroupDAO();		
		return groupDAO.deleteGroupByUserId(userId);
	}
}
