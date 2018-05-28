package com.liuxc.microcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.liuxc.microcloud.filter.AuthorizationRequestFilter;

@Configuration
public class ZuulConfig {
	@Bean
	public AuthorizationRequestFilter getAuthorizationRequestFilter() {
		
		return new AuthorizationRequestFilter();
	}
}
