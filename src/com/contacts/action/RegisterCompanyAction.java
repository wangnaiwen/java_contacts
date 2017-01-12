package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Company;
import com.contacts.domain.User;
import com.contacts.service.dao.RegisterCompanyServiceDAO;
import com.contacts.service.dao.SelectUserServiceByIdDAO;

public class RegisterCompanyAction {
	private Company company;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private RegisterCompanyServiceDAO registerCompanyServiceDAO;
    private SelectUserServiceByIdDAO selectUserServiceByIdDAO;
    private Integer creator;

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public SelectUserServiceByIdDAO getSelectUserServiceByIdDAO() {
		return selectUserServiceByIdDAO;
	}

	public void setSelectUserServiceByIdDAO(
			SelectUserServiceByIdDAO selectUserServiceByIdDAO) {
		this.selectUserServiceByIdDAO = selectUserServiceByIdDAO;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setRegisterCompanyServiceDAO(
			RegisterCompanyServiceDAO registerCompanyServiceDAO) {
		this.registerCompanyServiceDAO = registerCompanyServiceDAO;
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
		User user = selectUserServiceByIdDAO.selectUserById(creator);
		company.setUser(user);
		dataMap = new HashMap<String, Object>();
		boolean isSuccess = registerCompanyServiceDAO.registerCompany(company);
		dataMap.put("ret", isSuccess);
		return "success";
	}
}
