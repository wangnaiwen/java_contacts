package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.service.dao.DeleteGroupByUserIdServiceDAO;

public class DeleteGroupByUserIdAction {
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int userId;
    private DeleteGroupByUserIdServiceDAO deleteGroupByUserIdServiceDAO;
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public DeleteGroupByUserIdServiceDAO getDeleteGroupByUserIdServiceDAO() {
		return deleteGroupByUserIdServiceDAO;
	}

	public void setDeleteGroupByUserIdServiceDAO(
			DeleteGroupByUserIdServiceDAO deleteGroupByUserIdServiceDAO) {
		this.deleteGroupByUserIdServiceDAO = deleteGroupByUserIdServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
    public String execute() throws Exception{
    	
    	boolean result = deleteGroupByUserIdServiceDAO.deleteGroupByUserId(userId);
    	dataMap = new HashMap<String, Object>();
		dataMap.put("ret", result);
		return "success";
	}
}
