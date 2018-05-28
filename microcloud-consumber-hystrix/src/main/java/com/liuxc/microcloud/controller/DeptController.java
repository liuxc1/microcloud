package com.liuxc.microcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.service.IDeptClientService_Zuul;

@RestController
@RequestMapping("/consumer")
public class DeptController {
	@Autowired
	private IDeptClientService_Zuul deptService;

	@RequestMapping(value = "/dept/add", method = RequestMethod.GET)
	public Object add(Dept dept) {
		Boolean flag = deptService.add(dept);
		return flag;
	}

	@RequestMapping(value = "/dept/findById", method = RequestMethod.GET)
	public Object findById(Long id) {
		Dept dept = deptService.findById(id);
		return dept;
	}

	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public Object findAll() {
		System.out.println("****************"+deptService+"****************");
		List<Dept> list = deptService.findAll();
		return list;
	}
}
