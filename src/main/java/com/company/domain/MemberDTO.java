package com.company.domain;

import java.util.Date;

public class MemberDTO {
	
	private String user_id;
	private String password;
	private String e_mail;
	private Date join_date;
	private String AuthKey;
	
	
	
	public String getAuthKey() {
		return AuthKey;
	}
	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	@Override
	public String toString() {
	
		return "MemberDTO [user_id="+user_id+",password="+password+",e_mail="+e_mail+",join_date="+join_date+"]";
		
	}

	

}
