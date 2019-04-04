package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class Categories {
private Long pkcategoryid;
private String categoryname;
private Character isparent;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private Set<Categories> categories;
private Set<AdPost> adpost;
private Categories category;

public Long getPkcategoryid() {
	return pkcategoryid;
}
public void setPkcategoryid(Long pkcategoryid) {
	this.pkcategoryid = pkcategoryid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public Character getIsparent() {
	return isparent;
}
public void setIsparent(Character isparent) {
	this.isparent = isparent;
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
public Set<Categories> getCategories() {
	return categories;
}
public void setCategories(Set<Categories> categories) {
	this.categories = categories;
}
public Set<AdPost> getAdpost() {
	return adpost;
}
public void setAdpost(Set<AdPost> adpost) {
	this.adpost = adpost;
}
public Categories getCategory() {
	return category;
}
public void setCategory(Categories category) {
	this.category = category;
}

}
