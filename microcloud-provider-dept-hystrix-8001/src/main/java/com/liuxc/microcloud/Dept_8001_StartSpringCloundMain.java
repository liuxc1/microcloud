package com.liuxc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 启用eureka客服端
@EnableDiscoveryClient // 启用eureka复现服务
@EnableCircuitBreaker // 熔断服务
public class Dept_8001_StartSpringCloundMain extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Dept_8001_StartSpringCloundMain.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Dept_8001_StartSpringCloundMain.class, args);
	}
}
