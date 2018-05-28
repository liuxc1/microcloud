package com.liuxc.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureKa_Config_7005_StartSpringCloundMain extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EureKa_Config_7005_StartSpringCloundMain.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EureKa_Config_7005_StartSpringCloundMain.class, args);
	}
}
