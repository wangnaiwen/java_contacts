package com.contacts.dao;

import java.util.List;

import com.contacts.domain.Contacts;

public interface ContactsDAO {
	public boolean insertContacts(Contacts contacts);
	public boolean updateContacts(Contacts contacts);
	public boolean deleteContacts(Contacts contacts);
	public Contacts selectContactsById(int id);
	public Contacts selectContactsByPhone(String phone);
	public List<Contacts> selectContactsByGroupId(int groupId);
}
