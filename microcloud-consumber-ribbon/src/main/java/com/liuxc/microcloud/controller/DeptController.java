package com.liuxc.microcloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuxc.commons.MyLoadBalancedConfig;
import com.liuxc.microcloud.api.Dept;

@RestController
@RequestMapping("/consumer")
@RibbonClient(name="microcloud-provider-dept",configuration=MyLoadBalancedConfig.class)
//这里name 应该和yml 文件中的配置名称一致
public class DeptController {
	private  final String REST_DEPR_TOPIC="microcloud-provider-dept";
	@Autowired
	private RestTemplate template;
	@Autowired
	private HttpHeaders headers;//加入请求头
	@Autowired
	private LoadBalancerClient  ribbonCilent;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public Object findAll() {
		ServiceInstance serviceInstance = ribbonCilent.choose(REST_DEPR_TOPIC);
		System.out.println("主机："+serviceInstance.getHost()+",端口："+serviceInstance.getPort());
		URI deptUri=URI.create(String.format("http://%s:%s/dept/findAll", serviceInstance.getHost(),serviceInstance.getPort()));
		List<Dept> list = template.exchange(deptUri, HttpMethod.GET, new HttpEntity<Object>(headers), List.class).getBody();
		return list;
	}
}
