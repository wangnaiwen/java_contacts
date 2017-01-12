package com.contacts.action;

import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.json.annotations.JSON;
import com.contacts.domain.User;
import com.contacts.service.dao.LoginServiceDAO;

public class LoginAction {
	private User user;
	private LoginServiceDAO loginServiceDAO;
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
	public String execute() throws Exception{
		boolean validated = false;
		
		System.out.println(user.getPhone() + ": " + user.getPassword());
		User u = loginServiceDAO.login(user.getPhone(), user.getPassword());
		
		if(u != null){
			validated = true;
		}
		dataMap = new HashMap<String, Object>();  
		
		if(validated){
			dataMap.put("user", u);
		}else {
			dataMap.put("user", u);
		}
		return "success";
	}

    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
    
	public void setLoginServiceDAO(LoginServiceDAO loginServiceDAO) {
		this.loginServiceDAO = loginServiceDAO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}
