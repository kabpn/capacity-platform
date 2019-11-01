package com.capacity.qa.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 * feign拦截器
 */
@Configuration
public class FeignInterceptorConfig {


	/**
	 * 使用feign client访问别的微服务时，将access_token放入参数或者header ，Authorization:Bearer xxx
	 * 或者url?access_token=xxx
	 */
	@Bean
	public RequestInterceptor requestInterceptor() {
		RequestInterceptor requestInterceptor = new RequestInterceptor() {

			@Override
			public void apply(RequestTemplate template) {

				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpServletRequest request = attributes.getRequest();

				String token =request.getHeader("token");
				template.header("token",token);
			}
		};

		return requestInterceptor;
	}
}
