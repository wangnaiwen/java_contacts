package com.contacts.service.dao;

import com.contacts.dao.ContactsDAO;

public class ContactsBaseServiceDAO {
	private ContactsDAO contactsDAO;

	public ContactsDAO getContactsDAO() {
		return contactsDAO;
	}

	public void setContactsDAO(ContactsDAO contactsDAO) {
		this.contactsDAO = contactsDAO;
	}
	
}
