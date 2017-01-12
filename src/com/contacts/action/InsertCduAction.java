package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Cdu;
import com.contacts.domain.Company;
import com.contacts.domain.Department;
import com.contacts.domain.User;
import com.contacts.service.dao.InsertCduServiceDAO;
import com.contacts.service.dao.SelectCompanyByIdDAO;
import com.contacts.service.dao.SelectDepartmentByIdDAO;
import com.contacts.service.dao.SelectUserServiceByIdDAO;

public class InsertCduAction {

	private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int cid;
    private int did;
    private int uid;
    private String position;
    
    private SelectDepartmentByIdDAO selectDepartmentByIdDAO;
    private SelectCompanyByIdDAO selectCompanyByIdDAO;
    private SelectUserServiceByIdDAO selectUserServiceByIdDAO;
    private InsertCduServiceDAO insertCduServiceDAO;

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setSelectUserServiceByIdDAO(
			SelectUserServiceByIdDAO selectUserServiceByIdDAO) {
		this.selectUserServiceByIdDAO = selectUserServiceByIdDAO;
	}


	public void setInsertCduServiceDAO(InsertCduServiceDAO insertCduServiceDAO) {
		this.insertCduServiceDAO = insertCduServiceDAO;
	}


	public void setSelectCompanyByIdDAO(SelectCompanyByIdDAO selectCompanyByIdDAO) {
		this.selectCompanyByIdDAO = selectCompanyByIdDAO;
	}
	
	public void setSelectDepartmentByIdDAO(
			SelectDepartmentByIdDAO selectDepartmentByIdDAO) {
		this.selectDepartmentByIdDAO = selectDepartmentByIdDAO;
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
		System.out.println(cid + " " +did + " " + uid +" " +position);
		Department department = selectDepartmentByIdDAO.selectDepartmentById(did);
		Company company = selectCompanyByIdDAO.selectCompanyById(cid);
		User user = selectUserServiceByIdDAO.selectUserById(uid);
		Cdu cdu = new Cdu();
		cdu.setCompany(company);
		cdu.setDepartment(department);
		cdu.setUser(user);
		cdu.setPosition(position);
		boolean isSuccess = insertCduServiceDAO.insertCdu(cdu);
		dataMap = new HashMap<String, Object>();
		dataMap.put("ret", isSuccess);
		return "success";
	}
	
}
