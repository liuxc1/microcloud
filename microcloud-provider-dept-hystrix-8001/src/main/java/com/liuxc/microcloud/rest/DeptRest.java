package com.liuxc.microcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/dept")
public class DeptRest {
	@Autowired
	private IDeptService deptService;

	@HystrixCommand(fallbackMethod = "fallbackFindById")//如果执行findById方法出现了错误则执行fallbackFindById方法
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Dept findById(@PathVariable Long id) {
		Dept dept = deptService.findById(id);
		if (dept == null) {
			throw new RuntimeException();
		}
		return deptService.findById(id);
	}

	public Dept fallbackFindById(@PathVariable Long id) {// 此时方法的参数和findById 一致
		Dept dept = new Dept();
		dept.setId(id);
		dept.setName("ERROR: ID not found dept");
		dept.setLoc("null dataBase");
		return dept;
	}

}
