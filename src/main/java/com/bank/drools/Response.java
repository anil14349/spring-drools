package com.bank.drools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private String url;
	private List<String> attributes = new ArrayList<String>();
	private Customer customer;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public void addAttributes(String attribute) {
		this.attributes.add(attribute);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
