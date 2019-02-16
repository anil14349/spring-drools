package com.bank.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.config.DroolsBeanFactory;
import com.drools.Customer;
import com.drools.Response;

@RestController
public class DroolsController {

	 KieSession kieSession;
	 Customer customer;
	 
	@PostMapping("/getConfig")
	public Response getConfig(@RequestBody Customer customer) {
		kieSession = new DroolsBeanFactory().getKieSession();
		kieSession.insert(customer);
		Response response=new Response();
		List<String> attributes = new ArrayList<String>();
		Map<String,String> map=new HashMap<String,String>();
		kieSession.setGlobal("attributes", attributes);
		kieSession.setGlobal("map", map);
		System.out.println(kieSession.fireAllRules());
		response.setAttributes(attributes);
		response.setUrl(map.get("url"));
		response.setCustomer(customer);
		System.out.println("*********"+response.getAttributes());
		return response;
	}
}
