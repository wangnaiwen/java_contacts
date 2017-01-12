package com.contacts.service.dao;

import java.util.List;

import com.contacts.domain.Contacts;

public interface SelectContactsByGroupIdServiceDAO {
	List<Contacts> selectContactsByGroupId(int groupId);
}
