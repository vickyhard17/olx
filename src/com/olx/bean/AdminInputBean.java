package com.olx.bean;

public class AdminInputBean 
{
	private String state;
	private String city;
	private String area;
	private String category;
	private String subCategory;
	private Character showVerified;
	private Character showAllAdd;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Character getShowVerified() {
		return showVerified;
	}
	public void setShowVerified(Character showVerified) {
		this.showVerified = showVerified;
	}
	public Character getShowAllAdd() {
		return showAllAdd;
	}
	public void setShowAllAdd(Character showAllAdd) {
		this.showAllAdd = showAllAdd;
	}
	
}
