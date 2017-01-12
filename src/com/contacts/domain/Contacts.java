package com.contacts.domain;

/**
 * Contacts entity. @author MyEclipse Persistence Tools
 */

public class Contacts implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Grouping grouping;
	private String name;
	private String phone;
	private String phonemore;
	private String email;
	private String position;

	// Constructors

	/** default constructor */
	public Contacts() {
	}

	/** minimal constructor */
	public Contacts(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	/** full constructor */
	public Contacts(Grouping grouping, String name, String phone,
			String phonemore, String email, String position) {
		this.grouping = grouping;
		this.name = name;
		this.phone = phone;
		this.phonemore = phonemore;
		this.email = email;
		this.position = position;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Grouping getGrouping() {
		return this.grouping;
	}

	public void setGrouping(Grouping grouping) {
		this.grouping = grouping;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhonemore() {
		return this.phonemore;
	}

	public void setPhonemore(String phonemore) {
		this.phonemore = phonemore;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}