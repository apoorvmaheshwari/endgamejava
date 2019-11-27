package com.classifieds.admin.model;

public class Userad {
	private String email;
	
	private Ads ad;
	public Userad() {
	}
	public Userad(String email,Ads ad) {
		super();
		this.email = email;
		
		this.ad = ad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Ads getAd() {
		return ad;
	}
	public void setAd(Ads ad) {
		this.ad = ad;
	}
	@Override
	public String toString() {
		return "Userad [email=" + email + ", ad=" + ad + "]";
	}
	
	
	
}
