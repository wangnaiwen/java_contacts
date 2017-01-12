package com.contacts.service;

import com.contacts.dao.ContactsDAO;
import com.contacts.domain.Contacts;
import com.contacts.service.dao.ContactsBaseServiceDAO;
import com.contacts.service.dao.SelectContactsByPhoneServiceDAO;

public class SelectContactsByPhoneServiceImpl extends ContactsBaseServiceDAO implements SelectContactsByPhoneServiceDAO{

	@Override
	public Contacts selectContactsByPhone(String phone) {
		ContactsDAO contactsDAO = getContactsDAO();
		return contactsDAO.selectContactsByPhone(phone);
	}

}
