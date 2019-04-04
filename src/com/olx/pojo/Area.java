package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class Area {
private Long pkareaid;
private String areaname;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private Set<AdPost> adpost;
private City city;

public Long getPkareaid() {
	return pkareaid;
}
public void setPkareaid(Long pkareaid) {
	this.pkareaid = pkareaid;
}
public String getAreaname() {
	return areaname;
}
public void setAreaname(String areaname) {
	this.areaname = areaname;
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
public Set<AdPost> getAdpost() {
	return adpost;
}
public void setAdpost(Set<AdPost> adpost) {
	this.adpost = adpost;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}

}
