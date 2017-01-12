package com.contacts.service.dao;

import java.util.List;
import com.contacts.domain.Grouping;

public interface SelectGroupByUserIdServiceDAO {
	List<Grouping> selectGroupByUserId(int userId);
}
