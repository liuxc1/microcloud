package com.liuxc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Consumer_Dept_Feign_StartSpringCloundMain extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Consumer_Dept_Feign_StartSpringCloundMain.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Consumer_Dept_Feign_StartSpringCloundMain.class, args);
	}
}
