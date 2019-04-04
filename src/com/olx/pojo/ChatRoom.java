package com.olx.pojo;

import java.util.Date;
import java.util.Set;

public class ChatRoom {
private Long pkchatroomid;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private Set<ChatInfo> chatinfo;
private AdPost adpost;
private UserInfo buyer;

public Long getPkchatroomid() {
	return pkchatroomid;
}
public void setPkchatroomid(Long pkchatroomid) {
	this.pkchatroomid = pkchatroomid;
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
public Set<ChatInfo> getChatinfo() {
	return chatinfo;
}
public void setChatinfo(Set<ChatInfo> chatinfo) {
	this.chatinfo = chatinfo;
}
public AdPost getAdpost() {
	return adpost;
}
public void setAdpost(AdPost adpost) {
	this.adpost = adpost;
}
public UserInfo getBuyer() {
	return buyer;
}
public void setBuyer(UserInfo buyer) {
	this.buyer = buyer;
}



}
