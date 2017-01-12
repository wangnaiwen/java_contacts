package com.contacts.bean;

import java.util.List;

public class UserContacts {

	private GroupBean groupBean;
	private List<ContactsBean> contactsList;

	
	public GroupBean getGroupBean() {
		return groupBean;
	}
	public void setGroupBean(GroupBean groupBean) {
		this.groupBean = groupBean;
	}
	public List<ContactsBean> getContactsList() {
		return contactsList;
	}
	public void setContactsList(List<ContactsBean> contactsList) {
		this.contactsList = contactsList;
	}
	
}
