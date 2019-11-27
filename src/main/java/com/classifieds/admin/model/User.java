package com.classifieds.admin.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class User {
	@Id
	private String id;
	private String name;
	private String password;
	private String email;
	private int phone;

	@DBRef
	private List<Ads> ad;

	public User() {

	}

	public User(String id, String name, String password, String email, int phone, List<Ads> ad) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;

		this.ad = ad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Ads> getAd() {
		return ad;
	}

	public void setAd(List<Ads> ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", ad=" + ad + "]";
	}
	
	
}
