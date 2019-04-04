package com.olx.bean;

public class CateogOutBean
{
	private Long catogId;
	private Long  subcatogId;
	private String catogName;
	private String subcatogName;
	private Character isparent;
	
	public Character getIsparent() {
		return isparent;
	}
	public void setIsparent(Character isparent) {
		this.isparent = isparent;
	}
	public Long getCatogId() {
		return catogId;
	}
	public void setCatogId(Long catogId) {
		this.catogId = catogId;
	}
	public Long getSubcatogId() {
		return subcatogId;
	}
	public void setSubcatogId(Long subcatogId) {
		this.subcatogId = subcatogId;
	}
	public String getCatogName() {
		return catogName;
	}
	public void setCatogName(String catogName) {
		this.catogName = catogName;
	}
	public String getSubcatogName() {
		return subcatogName;
	}
	public void setSubcatogName(String subcatogName) {
		this.subcatogName = subcatogName;
	}
	
}
