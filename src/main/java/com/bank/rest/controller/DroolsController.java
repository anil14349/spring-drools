package com.bank.rest.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.config.DroolsBeanFactory;
import com.drools.Customer;
import com.drools.Response;
import com.drools.Customer.CustomerType;

@RestController
public class DroolsController {

	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/getConfig")
	public Response getConfig(@RequestParam(value = "cin", defaultValue = "0000") String name) {
		KieSession kieSession = new DroolsBeanFactory().getKieSession();
		Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
		kieSession.insert(customer);
		kieSession.fireAllRules();
		System.out.println("*********"+customer.getDiscount());
		return new Response(customer.getDiscount(), String.format(template, name));
	}
}
