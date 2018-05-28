package com.liuxc.microcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
@Configuration
public class FeignClientConfig {

	@Bean
	public Logger.Level getFeignLoggerLevel() {

		return Logger.Level.FULL;
	}

	/**
	 * feign 处理权限认证处理 这里替换原来的 header
	 */
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {

		//return new BasicAuthRequestInterceptor("liuxc", "liuxc");
		return new BasicAuthRequestInterceptor("zuul", "zuul");
	}
}
