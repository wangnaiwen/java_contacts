package com.contacts.domain;

/**
 * Cdu entity. @author MyEclipse Persistence Tools
 */

public class Cdu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Company company;
	private User user;
	private Department department;
	private String position;

	// Constructors

	/** default constructor */
	public Cdu() {
	}

	/** minimal constructor */
	public Cdu(Company company, User user, Department department) {
		this.company = company;
		this.user = user;
		this.department = department;
	}

	/** full constructor */
	public Cdu(Company company, User user, Department department,
			String position) {
		this.company = company;
		this.user = user;
		this.department = department;
		this.position = position;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}