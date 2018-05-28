package com.liuxc.microcloud.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/upload")
public class UploadRest {

	@RequestMapping(value="/index",method=RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "uploadFallback") // 熔断机制
	public String upload(@RequestParam MultipartFile photo) {
		if (photo != null) {
			System.out.println("****uploadRest****" + photo.getOriginalFilename() + ",size:" + photo.getSize());
		}
		return "xx" + System.currentTimeMillis() + ".jpg";
	}

	/**
	 * 处理服务器上传失败的回调
	 */
	public String uploadFallback(@RequestParam MultipartFile photo) {
		return "nophoto.jpg";
	}

}
