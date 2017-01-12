package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Contacts;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.InsertContactsServiceDAO;
import com.contacts.service.dao.SelectGroupByIdServiceDAO;

public class InsertContactsAction {
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int id;
    private String name;
    private String phone;
    private String phonemore;
    private String email;
    private String position;
    private int groupId;
    
    private InsertContactsServiceDAO insertContactsServiceDAO;
    private SelectGroupByIdServiceDAO selectGroupByIdServiceDAO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhonemore() {
		return phonemore;
	}

	public void setPhonemore(String phonemore) {
		this.phonemore = phonemore;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	

	public InsertContactsServiceDAO getInsertContactsServiceDAO() {
		return insertContactsServiceDAO;
	}

	public void setInsertContactsServiceDAO(
			InsertContactsServiceDAO insertContactsServiceDAO) {
		this.insertContactsServiceDAO = insertContactsServiceDAO;
	}

	public SelectGroupByIdServiceDAO getSelectGroupByIdServiceDAO() {
		return selectGroupByIdServiceDAO;
	}

	public void setSelectGroupByIdServiceDAO(
			SelectGroupByIdServiceDAO selectGroupByIdServiceDAO) {
		this.selectGroupByIdServiceDAO = selectGroupByIdServiceDAO;
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
    	Contacts contacts = new Contacts();
    	contacts.setId(id);
    	contacts.setName(name);
    	contacts.setPhone(phone);
    	contacts.setPhonemore(phonemore);
    	contacts.setPosition(position);
    	contacts.setEmail(email);
    	
    	Grouping grouping = selectGroupByIdServiceDAO.selectGroupById(groupId);
    	contacts.setGrouping(grouping);
    	boolean result = insertContactsServiceDAO.insertContacts(contacts);
    	dataMap = new HashMap<String, Object>();  
    	dataMap.put("result", result);
		return "success";
	}
}
