package com.company.domain;

public class CategoryVO {
	
	/*
	 *  cateName varchar(20) not null,
		cateCode varchar(30) not null,
		cateCodeRef varchar(30) null,
	 * */
	
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
	
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
	
	
	

}
