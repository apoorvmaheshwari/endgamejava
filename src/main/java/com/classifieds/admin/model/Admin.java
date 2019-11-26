package com.classifieds.admin.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Admin {
	@DBRef
	private List<User> user;
	private String userName;
	private String password;
	@DBRef
	private List<Ads> ad;
	public Admin() {
		
	}
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public List<Ads> getAd() {
		return ad;
	}
	public void setAd(List<Ads> ad) {
		this.ad = ad;
	}
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
