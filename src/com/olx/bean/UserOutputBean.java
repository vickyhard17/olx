package com.olx.bean;

public class UserOutputBean
{
	private Long pkid;
	private String name;
	private long contact;
	private Character isAdmin;
	
	public Long getPkid() {
		return pkid;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Character getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Character isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
