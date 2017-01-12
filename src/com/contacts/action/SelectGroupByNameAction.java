package com.contacts.action;

import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

public class SelectGroupByNameAction {
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    

	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
    public String execute() throws Exception{
		return "success";
	}
}
