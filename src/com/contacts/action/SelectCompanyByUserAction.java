package com.contacts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Cdu;
import com.contacts.service.dao.SelectCompanyByUserServiceDAO;

public class SelectCompanyByUserAction {
	
	
	private int uid;
	private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private SelectCompanyByUserServiceDAO selectCompanyByUserServiceDAO;
    
    
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

  
    public SelectCompanyByUserServiceDAO getSelectCompanyByUserServiceDAO() {
		return selectCompanyByUserServiceDAO;
	}

	public void setSelectCompanyByUserServiceDAO(
			SelectCompanyByUserServiceDAO selectCompanyByUserServiceDAO) {
		this.selectCompanyByUserServiceDAO = selectCompanyByUserServiceDAO;
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
		System.out.println(uid);
		List<Cdu> cdus = selectCompanyByUserServiceDAO.selectCompanyByUser(uid);
		if(cdus == null){
			System.out.println(" is null");
		}else{
			
		}
		dataMap = new HashMap<String, Object>();
		dataMap.put("ret", cdus);
		
		return "success";
	}
	
}
