package com.kkzxm.ppmvc.controller.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//⾃定义的拦截器对象
@Autowired
private CRUDInterceptor CRUDInterceptor;

@Override
public void addInterceptors(InterceptorRegistry registry) {
	//注册⾃定义拦截器对象
	//设置拦截器拦截的请求路径
	registry.addInterceptor(CRUDInterceptor)
			.addPathPatterns("/add")
			.addPathPatterns("/delById")
			.addPathPatterns("/updateFindById")
			.addPathPatterns("/update");
	}

	/**
	 * 解决跨域问题
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				.allowCredentials(false)
				.maxAge(3600)
				.allowedHeaders("*");
	}
}
