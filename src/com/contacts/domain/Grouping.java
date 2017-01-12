package com.contacts.domain;


/**
 * Grouping entity. @author MyEclipse Persistence Tools
 */

public class Grouping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String name;

	// Constructors

	/** default constructor */
	public Grouping() {
	}

	/** minimal constructor */
	public Grouping(User user, String name) {
		this.user = user;
		this.name = name;
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

}