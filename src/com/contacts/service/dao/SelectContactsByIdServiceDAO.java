package com.contacts.service.dao;

import com.contacts.domain.Contacts;

public interface SelectContactsByIdServiceDAO {
	Contacts selectContactsById(int id);
}
