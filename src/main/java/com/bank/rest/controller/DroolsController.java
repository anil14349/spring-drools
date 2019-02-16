package com.bank.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.config.DroolsBeanFactory;
import com.bank.drools.Customer;
import com.bank.drools.Response;

@RestController
public class DroolsController {

	@Autowired
	Customer customer;
	
	@Autowired
	Response response;
	
	@Autowired
	DroolsBeanFactory droolsBeanFactory;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/getConfig")
	public String getConfig(@RequestBody Customer customer) {
		KieSession kieSession = droolsBeanFactory.getKieSession();
		kieSession.insert(customer);
		List<String> attributes = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		kieSession.setGlobal("attributes", attributes);
		kieSession.setGlobal("map", map);
		kieSession.fireAllRules();
		response.setAttributes(attributes);
		response.setCustomer(customer);
		
		String res = restTemplate.getForObject(map.get("url"), String.class);
		
		kieSession.dispose();
		return res;
	}
}
