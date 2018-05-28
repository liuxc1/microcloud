package com.liuxc.microcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecuityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		//表示/hystrix.stream和/turbine.stream访问路径不需要安全认证；/turbine.stream
		web.ignoring().antMatchers("/hystrix.stream","/turbine.stream");
	}
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {
		// 配置security 认证用户
		builder.inMemoryAuthentication().withUser("liuxc").password("liuxc").roles("USER").and().withUser("admin")
				.password("root").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 所有的请求都需要通过认证后才可以正常进行
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated().and().csrf().disable();
		// 所有rest的服务都需要设置session无状态模式提高效率
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
