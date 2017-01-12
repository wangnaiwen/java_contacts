package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Cd;
import com.contacts.domain.CdId;
import com.contacts.domain.Company;
import com.contacts.domain.Department;
import com.contacts.service.dao.InsertCdServiceDAO;
import com.contacts.service.dao.SelectCompanyByIdDAO;
import com.contacts.service.dao.SelectDepartmentByIdDAO;

public class InsertCdAction {
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private InsertCdServiceDAO insertCdServiceDAO;
    private SelectCompanyByIdDAO selectCompanyByIdDAO;
    private SelectDepartmentByIdDAO selectDepartmentByIdDAO;
    
    private Cd cd;

    private Integer cId;
    private Integer dId;
    
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public InsertCdServiceDAO getInsertCdServiceDAO() {
		return insertCdServiceDAO;
	}

	public void setInsertCdServiceDAO(InsertCdServiceDAO insertCdServiceDAO) {
		this.insertCdServiceDAO = insertCdServiceDAO;
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
		Company company = selectCompanyByIdDAO.selectCompanyById(cId);
		Department department = selectDepartmentByIdDAO.selectDepartmentById(dId);
		CdId cdId = new CdId();
		cdId.setCompany(company);
		cdId.setDepartment(department);
		cd = new Cd();
		cd.setId(cdId);
		dataMap = new HashMap<String, Object>();
		boolean isSuccess = insertCdServiceDAO.insertCd(cd);
		dataMap.put("ret", isSuccess);
		return "success";
	}
}
