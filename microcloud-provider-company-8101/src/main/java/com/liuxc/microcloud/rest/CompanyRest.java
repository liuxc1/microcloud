package com.liuxc.microcloud.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.liuxc.microcloud.api.Company;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/company")
public class CompanyRest {

	@HystrixCommand(fallbackMethod = "fallbackGetTitle")
	@RequestMapping(value = "/getTitle/{title}", method = RequestMethod.GET)
	public Company findById(@PathVariable("title") String title) {
		Company company = new Company();
		company.setTitle(title);
		company.setNote("www.liuxc.com");

		return company;
	}

	public Company fallbackGetTitle(@PathVariable("title") String title) {// 此时方法的参数和findById
		Company company = new Company();
		company.setTitle(title);
		company.setNote("www.liuxc.com");

		return company;
	}

}
