package com.contacts.service.dao;

import com.contacts.domain.Contacts;

public interface SelectContactsByPhoneServiceDAO {
	Contacts selectContactsByPhone(String phone);
}
