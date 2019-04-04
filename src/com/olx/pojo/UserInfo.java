package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class UserInfo {
private Long pkuserid;
private String username;
private String useremail;
private Long usermobile;
private String userpassword;
private String address;
private Character isadmin;
private Character isactive;
private Date createddate;
private Long	createdby;
private Date modifieddate;
private Long modifiedby;
private Set<AdPost> adpost;
private Set<ChatRoom> chatroom;
private Area area;

public Long getPkuserid() {
	return pkuserid;
}
public void setPkuserid(Long pkuserid) {
	this.pkuserid = pkuserid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUseremail() {
	return useremail;
}
public void setUseremail(String useremail) {
	this.useremail = useremail;
}
public Long getUsermobile() {
	return usermobile;
}
public void setUsermobile(Long usermobile) {
	this.usermobile = usermobile;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public Character getIsadmin() {
	return isadmin;
}
public void setIsadmin(Character isadmin) {
	this.isadmin = isadmin;
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
public Set<ChatRoom> getChatroom() {
	return chatroom;
}
public void setChatroom(Set<ChatRoom> chatroom) {
	this.chatroom = chatroom;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Area getArea() {
	return area;
}
public void setArea(Area area) {
	this.area = area;
}

}
