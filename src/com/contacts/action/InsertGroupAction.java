package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Grouping;
import com.contacts.domain.User;
import com.contacts.service.dao.InsertGroupServiceDAO;
import com.contacts.service.dao.SelectUserServiceByIdDAO;

public class InsertGroupAction {
	
	private int id;
	private String name;
	private int userId;
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private SelectUserServiceByIdDAO selectUserServiceByIdDAO;
    private InsertGroupServiceDAO insertGroupServiceDAO;

	public InsertGroupServiceDAO getInsertGroupServiceDAO() {
		return insertGroupServiceDAO;
	}

	public void setInsertGroupServiceDAO(InsertGroupServiceDAO insertGroupServiceDAO) {
		this.insertGroupServiceDAO = insertGroupServiceDAO;
	}
	
	public SelectUserServiceByIdDAO getSelectUserServiceByIdDAO() {
		return selectUserServiceByIdDAO;
	}

	public void setSelectUserServiceByIdDAO(
			SelectUserServiceByIdDAO selectUserServiceByIdDAO) {
		this.selectUserServiceByIdDAO = selectUserServiceByIdDAO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
    	Grouping grouping = new Grouping();
    	grouping.setName(name);
    	
    	User user = selectUserServiceByIdDAO.selectUserById(userId);
    	grouping.setUser(user);
    	grouping.setId(id);
    	boolean result = insertGroupServiceDAO.insertGroup(grouping);
    	
    	dataMap = new HashMap<String, Object>();  
    	dataMap.put("result", result);
		return "success";
	}
}
