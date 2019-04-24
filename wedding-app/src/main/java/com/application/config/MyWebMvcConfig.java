package com.application.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.application.interceptor.TokenInterceptor;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	TokenInterceptor tokenInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> patterns = new ArrayList<>();
		patterns.add("/app_passenger/**");
		registry.addInterceptor(tokenInterceptor).addPathPatterns(patterns);
		//WebMvcConfigurer.super.addInterceptors(registry);
	}

}
