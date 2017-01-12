package com.contacts.dao;

import java.util.List;

import com.contacts.domain.Grouping;

public interface GroupDAO {
	public boolean insertGroup(Grouping group);
	public boolean deleteGroup(Grouping group);
	public boolean updateGroup(Grouping group);
	public Grouping selectGroupById(int id);
	public Grouping selectGroupByName(String name);
	public List<Grouping> selectGroupByUserId(int userId);
	public boolean deleteGroupByUserId(int userId);
}
