package com.hsbc.rest.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drools.Customer;
import com.drools.Response;
import com.drools.Customer.CustomerType;
import com.hsbc.config.DroolsBeanFactory;

@RestController
public class DroolsController {

	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Response greeting(@RequestParam(value = "name", defaultValue = "Hsbc") String name) {
		KieSession kieSession = new DroolsBeanFactory().getKieSession();
		Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
		kieSession.insert(customer);
		kieSession.fireAllRules();
		System.out.println("*********"+customer.getDiscount());
		return new Response(customer.getDiscount(), String.format(template, name));
	}
}
