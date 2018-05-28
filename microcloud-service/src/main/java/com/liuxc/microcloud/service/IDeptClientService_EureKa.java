package com.liuxc.microcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.config.FeignClientConfig;
import com.liuxc.microcloud.fallback.IDeptClientServiceFallBackFactory;

/**
 * value 为eureKa中的服务名称 configuration 为权限认证配置
 */
@FeignClient(value = "MICROCLOUD-PROVIDER-DEPT", configuration = FeignClientConfig.class, fallbackFactory = IDeptClientServiceFallBackFactory.class)
public interface IDeptClientService_EureKa {
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);

	@RequestMapping(value = "/dept/findById/{id}", method = RequestMethod.GET)
	public Dept findById(@PathVariable(value = "id") Long id);

	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public List<Dept> findAll();
}
