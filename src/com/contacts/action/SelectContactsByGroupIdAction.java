package com.contacts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Contacts;
import com.contacts.service.dao.SelectContactsByGroupIdServiceDAO;

public class SelectContactsByGroupIdAction {
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int groupId;
    private SelectContactsByGroupIdServiceDAO selectContactsByGroupIdServiceDAO;
    
	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public SelectContactsByGroupIdServiceDAO getSelectContactsByGroupIdServiceDAO() {
		return selectContactsByGroupIdServiceDAO;
	}


	public void setSelectContactsByGroupIdServiceDAO(
			SelectContactsByGroupIdServiceDAO selectContactsByGroupIdServiceDAO) {
		this.selectContactsByGroupIdServiceDAO = selectContactsByGroupIdServiceDAO;
	}


	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
    
    public String execute() throws Exception{
    	dataMap = new HashMap<String, Object>();
    	List<Contacts> cList = selectContactsByGroupIdServiceDAO.selectContactsByGroupId(groupId);
    	dataMap.put("data", cList);
    	return "success";
	}
}
