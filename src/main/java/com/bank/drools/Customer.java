package com.bank.drools;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private int cin;
	private String srcSys;
	private String lob;
	private String country;

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getSrcSys() {
		return srcSys;
	}

	public void setSrcSys(String srcSys) {
		this.srcSys = srcSys;
	}

}