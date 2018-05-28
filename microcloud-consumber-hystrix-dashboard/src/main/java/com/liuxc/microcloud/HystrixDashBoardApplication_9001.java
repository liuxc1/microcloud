package com.liuxc.microcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication_9001 extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HystrixDashBoardApplication_9001.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixDashBoardApplication_9001.class, args);
	}
}
