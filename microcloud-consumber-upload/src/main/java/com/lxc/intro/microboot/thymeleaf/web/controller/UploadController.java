package com.lxc.intro.microboot.thymeleaf.web.controller;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.lxc.intro.microboot.thymeleaf.AbstractBaseController;

@Controller
@RequestMapping("/upload")
public class UploadController extends AbstractBaseController {
	public static final String UPLOAD_URL = "http://gateway-9501.com:9501/zuul/liuxc/upload-proxy/upload/index";

	@RequestMapping(value = "/index", method = RequestMethod.GET) // 接受参数，跳转页面
	public String index() {

		return "upload/upload_page";
	}
	@ResponseBody
	@RequestMapping(value = "/uploading", method = RequestMethod.POST) // 接受参数，跳转页面
	public String upload(String name, MultipartFile photo) throws IOException {
		if (photo != null) {// 处理上传
			CloseableHttpClient httpClient = HttpClients.createDefault();// 创建http客服端
			CredentialsProvider provider = new BasicCredentialsProvider();// 创建认证信息
			Credentials credentials = new UsernamePasswordCredentials("zuul", "zuul");
			provider.setCredentials(AuthScope.ANY, credentials);// 认证的范围

			HttpClientContext clientContext = HttpClientContext.create();
			clientContext.setCredentialsProvider(provider);

			HttpPost post = new HttpPost(UPLOAD_URL);
			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("photo", photo.getBytes(), ContentType.create("image/jpeg"), "temp.jpg").build();
			post.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(post, clientContext);
			HttpEntity responseEntity = response.getEntity();
			return EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
		}
		return "upload/index";
	}
}
