package com.olx.pojo;

import java.util.Date;

public class ChatInfo {
private Long pkchatinfoid;
private String message;
private Character isactive;
private Date createddate;
private Long createdby;
private Date modifieddate;
private Long modifiedby;
private ChatRoom chatroom;

public Long getPkchatinfoid() {
	return pkchatinfoid;
}
public void setPkchatinfoid(Long pkchatinfoid) {
	this.pkchatinfoid = pkchatinfoid;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
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
public ChatRoom getChatroom() {
	return chatroom;
}
public void setChatroom(ChatRoom chatroom) {
	this.chatroom = chatroom;
}


}
