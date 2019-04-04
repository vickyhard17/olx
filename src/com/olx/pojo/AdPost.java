package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class AdPost {
private Long pkadid;
private String title;
private String description;
private Float price;
private String imagename;
private String showmobile;
private Character isverified;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private Set<AdDetails> adetails;
private Set<ChatRoom> chatroom;
private Area area;
private UserInfo userinfo;
private Categories categories;

public Long getPkadid() {
	return pkadid;
}
public void setPkadid(Long pkadid) {
	this.pkadid = pkadid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public String getImagename() {
	return imagename;
}
public void setImagename(String imagename) {
	this.imagename = imagename;
}
public String getShowmobile() {
	return showmobile;
}
public void setShowmobile(String showmobile) {
	this.showmobile = showmobile;
}

public Character getIsverified() {
	return isverified;
}
public void setIsverified(Character isverified) {
	this.isverified = isverified;
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
public Set<AdDetails> getAdetails() {
	return adetails;
}
public void setAdetails(Set<AdDetails> adetails) {
	this.adetails = adetails;
}
public Set<ChatRoom> getChatroom() {
	return chatroom;
}
public void setChatroom(Set<ChatRoom> chatroom) {
	this.chatroom = chatroom;
}
public Area getArea() {
	return area;
}
public void setArea(Area area) {
	this.area = area;
}
public UserInfo getUserinfo() {
	return userinfo;
}
public void setUserinfo(UserInfo userinfo) {
	this.userinfo = userinfo;
}
public Categories getCategories() {
	return categories;
}
public void setCategories(Categories categories) {
	this.categories = categories;
}

}
