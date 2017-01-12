package com.contacts.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.contacts.domain.Cd;
import com.contacts.domain.CdId;
import com.contacts.domain.Company;
import com.contacts.domain.Department;
import com.contacts.service.dao.AddDepartmentServiceDAO;
import com.contacts.service.dao.InsertCdServiceDAO;
import com.contacts.service.dao.SelectCompanyByIdDAO;
import com.contacts.service.dao.SelectDepartmentByNameDAO;

public class AddDepartmentAction{
	
	private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private Integer cid;
    private String departmentname;
    
    private AddDepartmentServiceDAO addDepartmentServiceDAO;
    private SelectDepartmentByNameDAO selectDepartmentByNameDAO;
    private SelectCompanyByIdDAO selectCompanyByIdDAO;
    private InsertCdServiceDAO insertCdServiceDAO;
    
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public void setSelectCompanyByIdDAO(SelectCompanyByIdDAO selectCompanyByIdDAO) {
		this.selectCompanyByIdDAO = selectCompanyByIdDAO;
	}
	


	public SelectDepartmentByNameDAO getSelectDepartmentByNameDAO() {
		return selectDepartmentByNameDAO;
	}

	public void setSelectDepartmentByNameDAO(
			SelectDepartmentByNameDAO selectDepartmentByNameDAO) {
		this.selectDepartmentByNameDAO = selectDepartmentByNameDAO;
	}

	public void setInsertCdServiceDAO(InsertCdServiceDAO insertCdServiceDAO) {
		this.insertCdServiceDAO = insertCdServiceDAO;
	}

	public void setAddDepartmentServiceDAO(
			AddDepartmentServiceDAO addDepartmentServiceDAO) {
		this.addDepartmentServiceDAO = addDepartmentServiceDAO;
	}

	public AddDepartmentServiceDAO getAddDepartmentServiceDAO() {
		return addDepartmentServiceDAO;
	}


	public SelectCompanyByIdDAO getSelectCompanyByIdDAO() {
		return selectCompanyByIdDAO;
	}

	public InsertCdServiceDAO getInsertCdServiceDAO() {
		return insertCdServiceDAO;
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
		
		System.out.println(cid + "  " + departmentname);
		Department department = selectDepartmentByNameDAO.selectDepartmentByName(departmentname);
		
		if(department == null){
			department = new Department();
			department.setName(departmentname);
			addDepartmentServiceDAO.addDepartment(department);
			department = selectDepartmentByNameDAO.selectDepartmentByName(departmentname);
		}
		
		Company company = selectCompanyByIdDAO.selectCompanyById(cid);
		CdId cdId = new CdId(company, department);
		Cd cd = new Cd(cdId);	
		boolean isInsert = insertCdServiceDAO.insertCd(cd);
		
		dataMap = new HashMap<String, Object>();
		dataMap.put("ret", isInsert);
		
		return "success";
	}
}
