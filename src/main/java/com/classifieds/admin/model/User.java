package com.classifieds.admin.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class User {
	private String name;
	private String password;
	private String email;
	private int phone;
	private String date;
	@DBRef
	private List<Ads> ad;
	
	public User (){
		
	}



	public User(String name, String password, String email, int phone, String date, List<Ads> ad) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.ad = ad;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Ads> getAd() {
		return ad;
	}

	public void setAd(List<Ads> ad) {
		this.ad = ad;
	}
}
