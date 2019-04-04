package com.olx.pojo;

import java.util.Date;

public class AdDetails {
private Long pkaddetailid;
private String title;
private String value;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private AdPost adpost;

public Long getPkaddetailid() {
	return pkaddetailid;
}
public void setPkaddetailid(Long pkaddetailid) {
	this.pkaddetailid = pkaddetailid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
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
public AdPost getAdpost() {
	return adpost;
}
public void setAdpost(AdPost adpost) {
	this.adpost = adpost;
}


}
