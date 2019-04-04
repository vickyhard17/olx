package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class State
{
	private Long pkstateid;
	private String statename;
	private Character isactive;
	private Date createddate;
	private Long	createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Set<City> cities;

public Long getPkstateid() {
	return pkstateid;
}
public void setPkstateid(Long pkstateid) {
	this.pkstateid = pkstateid;
}
public String getStatename() {
	return statename;
}
public void setStatename(String statename) {
	this.statename = statename;
}
public Character getIsactive() {
	return isactive;
}
public void setIsactive(Character isactive) {
	this.isactive = isactive;
}
public Date getCreateddate() {
	return createddate;
}
public void setCreateddate(Date createddate) {
	this.createddate = createddate;
}
public Long getCreatedby() {
	return createdby;
}
public void setCreatedby(Long createdby) {
	this.createdby = createdby;
}
public Date getModifieddate() {
	return modifieddate;
}
public void setModifieddate(Date modifieddate) {
	this.modifieddate = modifieddate;
}
public Long getModifiedby() {
	return modifiedby;
}
public void setModifiedby(Long modifiedby) {
	this.modifiedby = modifiedby;
}
public Set<City> getCities() {
	return cities;
}
public void setCities(Set<City> cities) {
	this.cities = cities;
}

}
