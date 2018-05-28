package com.liuxc.commons;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

public class MyLoadBalancedConfig {
	@Bean
	public IRule ribbonRule(){
		
		return new com.netflix.loadbalancer.RandomRule();//随机访问
	}
}
