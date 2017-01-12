package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.User;
import com.contacts.service.dao.RegisterServiceDAO;
import com.contacts.service.dao.SelectUserByPhoneDAO;

public class RegisterAction {
	
	private User user;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private RegisterServiceDAO registerServiceDAO;
    private SelectUserByPhoneDAO selectUserByPhoneDAO;
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public void setRegisterServiceDAO(RegisterServiceDAO registerServiceDAO) {
		this.registerServiceDAO = registerServiceDAO;
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
		if(selectUserByPhoneDAO.SelectUserByPhone(user.getPhone()) == null){
			boolean isSuccess = registerServiceDAO.register(user);
			dataMap.put("ret", isSuccess);
		}else{
			dataMap.put("ret", false);
		}
		return "success";
	}

	public SelectUserByPhoneDAO getSelectUserByPhoneDAO() {
		return selectUserByPhoneDAO;
	}

	public void setSelectUserByPhoneDAO(SelectUserByPhoneDAO selectUserByPhoneDAO) {
		this.selectUserByPhoneDAO = selectUserByPhoneDAO;
	}
}
