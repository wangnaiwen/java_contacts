package com.contacts.domain;

/**
 * CdId entity. @author MyEclipse Persistence Tools
 */

public class CdId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Company company;
	private Department department;

	// Constructors

	/** default constructor */
	public CdId() {
	}

	/** full constructor */
	public CdId(Company company, Department department) {
		this.company = company;
		this.department = department;
	}

	// Property accessors

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CdId))
			return false;
		CdId castOther = (CdId) other;

		return ((this.getCompany() == castOther.getCompany()) || (this
				.getCompany() != null && castOther.getCompany() != null && this
				.getCompany().equals(castOther.getCompany())))
				&& ((this.getDepartment() == castOther.getDepartment()) || (this
						.getDepartment() != null
						&& castOther.getDepartment() != null && this
						.getDepartment().equals(castOther.getDepartment())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		result = 37
				* result
				+ (getDepartment() == null ? 0 : this.getDepartment()
						.hashCode());
		return result;
	}

}