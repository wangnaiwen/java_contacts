package com.contacts.service;

import com.contacts.dao.ContactsDAO;
import com.contacts.domain.Contacts;
import com.contacts.service.dao.ContactsBaseServiceDAO;
import com.contacts.service.dao.InsertContactsServiceDAO;

public class InsertContactsServiceImpl extends ContactsBaseServiceDAO implements InsertContactsServiceDAO{

	@Override
	public boolean insertContacts(Contacts contacts) {
		ContactsDAO contactsDAO = getContactsDAO();
		return contactsDAO.insertContacts(contacts);
	}

}
