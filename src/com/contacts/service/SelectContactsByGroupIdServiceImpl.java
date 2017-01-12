package com.contacts.service;

import java.util.List;

import com.contacts.dao.ContactsDAO;
import com.contacts.domain.Contacts;
import com.contacts.service.dao.ContactsBaseServiceDAO;
import com.contacts.service.dao.SelectContactsByGroupIdServiceDAO;

public class SelectContactsByGroupIdServiceImpl extends ContactsBaseServiceDAO implements SelectContactsByGroupIdServiceDAO{

	@Override
	public List<Contacts> selectContactsByGroupId(int groupId) {
		ContactsDAO contactsDAO = getContactsDAO();
		return contactsDAO.selectContactsByGroupId(groupId);
	}

}
