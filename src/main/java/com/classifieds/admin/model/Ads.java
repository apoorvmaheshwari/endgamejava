package com.classifieds.admin.model;

import org.springframework.data.annotation.Id;

public class Ads {
	@Id
	private String id;
	private String category;
	private String postTitle;
	private int postCode;
	private String descrip;
	private String email;
	private String phoneNo;
	private Boolean statusAvail;
	private Boolean statusFlag;
	public Ads() {

	}

	public Ads(String id,String category, String postTitle, int postCode, String descrip, String email, String phoneNo) {
		super();
		this.id=id;
		this.category = category;
		this.postTitle = postTitle;
		this.postCode = postCode;
		this.descrip = descrip;
		this.email = email;
		this.phoneNo = phoneNo;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Boolean getStatusAvail() {
		return statusAvail;
	}

	public void setStatusAvail(Boolean statusAvail) {
		this.statusAvail = statusAvail;
	}

	public Boolean getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Boolean statusFlag) {
		this.statusFlag = statusFlag;
	}

	@Override
	public String toString() {
		return "Ads [id=" + id + ", category=" + category + ", postTitle=" + postTitle + ", postCode=" + postCode
				+ ", descrip=" + descrip + ", email=" + email + ", phoneNo=" + phoneNo + ", statusAvail=" + statusAvail
				+ ", statusFlag=" + statusFlag + "]";
	}
	
	

}
