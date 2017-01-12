package com.contacts.domain;


/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String name;
	private String updatetime;
	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String name, String updatetime) {
		this.name = name;
		this.updatetime = updatetime;
	}

	/** full constructor */
	public Company(User user, String name, String updatetime) {
		this.name = name;
		this.updatetime = updatetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}