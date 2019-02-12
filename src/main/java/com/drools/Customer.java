package com.drools;

public class Customer {
	private CustomerType type;

	private int years;

	private int discount;

	public Customer(CustomerType type, int discount) {
		this.type = type;
		this.discount = discount;
	}

	public enum CustomerType {
		INDIVIDUAL, BUSINESS;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}