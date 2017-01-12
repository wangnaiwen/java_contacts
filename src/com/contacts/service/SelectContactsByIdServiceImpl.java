package com.contacts.service;

import com.contacts.dao.ContactsDAO;
import com.contacts.domain.Contacts;
import com.contacts.service.dao.ContactsBaseServiceDAO;
import com.contacts.service.dao.SelectContactsByIdServiceDAO;

public class SelectContactsByIdServiceImpl extends ContactsBaseServiceDAO implements SelectContactsByIdServiceDAO{

	@Override
	public Contacts selectContactsById(int id) {
		ContactsDAO contactsDAO = getContactsDAO();
		return contactsDAO.selectContactsById(id);
	}

}
