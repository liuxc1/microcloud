package com.liuxc.microcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuxc.microcloud.api.Dept;

@RestController
@RequestMapping("/consumer")
public class DeptController {
	@Autowired
	private RestTemplate template;

	@Autowired
	private HttpHeaders headers;//加入请求头
	
	@Autowired
	private LoadBalancerClient  ribbonCilent;

	@RequestMapping(value = "/dept/add", method = RequestMethod.GET)
	public Object add(Dept dept) {
		Boolean flag = template.exchange("http://MICROCLOUD-PROVIDER-DEPT/dept/add", HttpMethod.GET, new HttpEntity<Object>(dept,headers), Boolean.class). getBody();
		//Boolean flag = template.postForObject("http://www.lxc.com:8001/dept/add", dept, boolean.class);
		return flag;
	}

	@RequestMapping(value = "/dept/findById", method = RequestMethod.GET)
	public Object findById(Long id) {
		Dept dept =template.exchange("http://MICROCLOUD-PROVIDER-DEPT/dept/findById/" + id, HttpMethod.GET, new HttpEntity<Object>(headers), Dept.class).getBody();
		//Dept dept = template.getForObject("http://www.lxc.com:8001/dept/findById/" + id, Dept.class);
		return dept;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public Object findAll() {
		ServiceInstance serviceInstance = ribbonCilent.choose("MICROCLOUD-PROVIDER-DEPT");
		System.out.println("主机："+serviceInstance.getHost()+",端口："+serviceInstance.getPort());
		List<Dept> list = template.exchange("http://MICROCLOUD-PROVIDER-DEPT/dept/findAll", HttpMethod.GET, new HttpEntity<Object>(headers), List.class).getBody();
		//List<Dept> list = template.getForObject("http://liuxc:liuxc@www.lxc.com:8001/dept/findAll", List.class);
		return list;
	}
}
