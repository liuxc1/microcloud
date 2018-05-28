package com.liuxc.microcloud.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
@Component
public class DeptProviderFallBack implements ZuulFallbackProvider {

	@Override
	public String getRoute() {// 设置路由的地址
		return "microcloud-provider-dept";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {// 设置回退信息
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("\"message\":\"路由失败！\"".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Type", "text/html; charset=UTF-8");
				return headers;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {

				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {

			}

		};
	}

}
