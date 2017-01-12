package com.contacts.dao;

import com.contacts.domain.Cd;

public interface ICdDAO {
	public boolean insertCd(Cd cd);
	public boolean deleteCd(Cd cd);
	public boolean updateC(Cd cd);
}
