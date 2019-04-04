package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class City {
private Long pkcityid;
private String  cityname;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private Set<Area> areas;
private State state;

public Long getPkcityid() {
	return pkcityid;
}
public void setPkcityid(Long pkcityid) {
	this.pkcityid = pkcityid;
}
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
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
public Set<Area> getAreas() {
	return areas;
}
public void setAreas(Set<Area> areas) {
	this.areas = areas;
}
public State getState() {
	return state;
}
public void setState(State state) {
	this.state = state;
}

}
