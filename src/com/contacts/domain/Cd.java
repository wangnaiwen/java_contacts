package com.contacts.domain;

/**
 * Cd entity. @author MyEclipse Persistence Tools
 */

public class Cd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CdId id;

	// Constructors

	/** default constructor */
	public Cd() {
	}

	/** full constructor */
	public Cd(CdId id) {
		this.id = id;
	}

	// Property accessors

	public CdId getId() {
		return this.id;
	}

	public void setId(CdId id) {
		this.id = id;
	}

}