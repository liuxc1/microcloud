package com.liuxc.microcloud.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.service.IDeptService;

@RestController
@RequestMapping("/dept")
public class DeptRest {
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private DiscoveryClient  client; 

	@RequestMapping(value = "desCover", method = RequestMethod.GET)
	public Object desCover() {
		
		return client;
	}
	
	@RequestMapping(value = "getSessionId", method = RequestMethod.GET)
	public String getSessionId(HttpServletRequest request) {

		return request.getSession().getId();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean insert(@RequestBody Dept dept) {

		return deptService.insert(dept);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Dept findById(@PathVariable Long id) {

		return deptService.findById(id);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Dept> findAll() {

		return deptService.findAll();
	}
}
