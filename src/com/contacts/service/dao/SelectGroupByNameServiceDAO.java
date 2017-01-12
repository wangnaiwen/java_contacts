package com.contacts.service.dao;

import com.contacts.domain.Grouping;

public interface SelectGroupByNameServiceDAO {
	Grouping selectGroupByName(String name);
}
