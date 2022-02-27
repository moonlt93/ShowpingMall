package com.company.domain;

import java.util.Date;

import lombok.Data;


public class productVO {
	
	
	private int showNo;
	private String name;
	private String contents;
	private String writer;
	private String images;
	private String detail;
	private String color;
	private String size;
	private Date regDate;
	private int viewCnt;
	
	public int getShowNo() {
		return showNo;
	}
	public void setShowNo(int showNo) {
		this.showNo = showNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
	

}

/*create table showpinglist(
showNo int not null auto_increment,
name varchar(200) not null,
contents varchar(400),
writer varchar(60),
images text,
detail text,
color varchar(20),
size varchar(10),
regDate timestamp default now(),
viewCnt int default 0,
primary key(showNo)
)
;	*/
