package com.contacts.dao;

import java.util.List;

import com.contacts.domain.Cdu;

public interface ICduDAO {
	public boolean insertCdu(Cdu cdu);
	public boolean updateCdu(Cdu cdu);
	public boolean deleteCdu(Cdu cdu);
	public List<Cdu> selectCduBycId(int cId);
	public List<Cdu> selectCduByuId(int uId);
}
