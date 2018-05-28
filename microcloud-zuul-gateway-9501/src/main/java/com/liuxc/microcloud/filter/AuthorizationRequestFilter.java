package com.liuxc.microcloud.filter;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthorizationRequestFilter extends ZuulFilter {// 认证授权过滤器

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		String auth = "liuxc:liuxc"; // 认证原始信息
		byte[] encode = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));// 进行加密处理
		String authHeader = "Basic " + new String(encode);
		currentContext.addZuulRequestHeader("Authorization", authHeader);
		return null;
	}

	@Override
	public boolean shouldFilter() {// 是否需要执行该过滤器
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;//设置优先级
	}

	@Override
	public String filterType() {
		//在设置zuul过滤时，可以设置其过滤的位置
		//1.pre:在请求发出前，执行过滤。如果要进行认证访问，肯定在请求前设置头信息
		//2.route：在进行路由请求的时候被调用
		//3.post：在路由之后发送请求时被调用
		//4.error：出现错误之后进行调用
		return "pre";
	}

}
