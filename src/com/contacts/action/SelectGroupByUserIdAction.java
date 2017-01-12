package com.contacts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.bean.ContactsBean;
import com.contacts.bean.GroupBean;
import com.contacts.bean.UserContacts;
import com.contacts.domain.Contacts;
import com.contacts.domain.Grouping;
import com.contacts.service.dao.SelectContactsByGroupIdServiceDAO;
import com.contacts.service.dao.SelectGroupByUserIdServiceDAO;

public class SelectGroupByUserIdAction {
	private Map<String,Object> dataMap;
	private String key = "Just see see";   
	private int userId;
	
	private SelectGroupByUserIdServiceDAO selectGroupByUserIdServiceDAO;
	private SelectContactsByGroupIdServiceDAO selectContactsByGroupIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public SelectGroupByUserIdServiceDAO getSelectGroupByUserIdServiceDAO() {
		return selectGroupByUserIdServiceDAO;
	}

	public void setSelectGroupByUserIdServiceDAO(
			SelectGroupByUserIdServiceDAO selectGroupByUserIdServiceDAO) {
		this.selectGroupByUserIdServiceDAO = selectGroupByUserIdServiceDAO;
	}

	public SelectContactsByGroupIdServiceDAO getSelectContactsByGroupIdServiceDAO() {
		return selectContactsByGroupIdServiceDAO;
	}

	public void setSelectContactsByGroupIdServiceDAO(
			SelectContactsByGroupIdServiceDAO selectContactsByGroupIdServiceDAO) {
		this.selectContactsByGroupIdServiceDAO = selectContactsByGroupIdServiceDAO;
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

    	dataMap = new HashMap<String, Object>();
    	List<UserContacts> userContactsList = null;
    	List<Grouping> gList = selectGroupByUserIdServiceDAO.selectGroupByUserId(userId);
    	
    	if(gList !=null){
    		int length = gList.size();
    		userContactsList = new ArrayList<UserContacts>();
    		for(int i = 0; i < length; i++){
    			Grouping grouping = gList.get(i);
    			GroupBean groupBean = new GroupBean();
    			groupBean.setId(grouping.getId());
    			groupBean.setName(grouping.getName());
    			groupBean.setUserId(grouping.getUser().getId());
    			List<Contacts> cList = selectContactsByGroupIdServiceDAO.selectContactsByGroupId(gList.get(i).getId());
    			
    			List<ContactsBean> contactsBeans = null;
    			if(cList != null){
    				int cLength = cList.size();
    				contactsBeans = new ArrayList<ContactsBean>();
        			for(int j = 0; j < cLength; j++){
        				ContactsBean contactsBean = new ContactsBean();
        				Contacts c = cList.get(j);
        				contactsBean.setId(c.getId());
        				contactsBean.setName(c.getName());
        				contactsBean.setEmail(c.getEmail());
        				contactsBean.setPhone(c.getPhone());
        				contactsBean.setPhonemore(c.getPhonemore());
        				contactsBean.setPosition(c.getPosition());
        				contactsBean.setGroupId(c.getGrouping().getId());
        				contactsBeans.add(contactsBean);
        			}	
    			}
    			
    			UserContacts userContacts = new UserContacts();
    			userContacts.setGroupBean(groupBean);
    			userContacts.setContactsList(contactsBeans);
    			userContactsList.add(userContacts);
    		}
    	}
    	dataMap.put("result", userContactsList);
		return "success";
	}
}
