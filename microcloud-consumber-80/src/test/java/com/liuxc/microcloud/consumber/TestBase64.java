package com.liuxc.microcloud.consumber;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

public class TestBase64 {
	@Test
	public void test() throws Exception {
		String auth = "liuxc:liuxc"; // 认证原始信息
		byte[] encode = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));// 进行加密处理
		String authHeader = "Basic " + new String(encode);
		
		System.out.println(authHeader);
	}
}
