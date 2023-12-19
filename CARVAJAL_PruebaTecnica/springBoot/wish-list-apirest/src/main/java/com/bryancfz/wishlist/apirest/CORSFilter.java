package com.bryancfz.wishlist.apirest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-cors-global-java
 * */
@Configuration
public class CORSFilter implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//			.allowedOrigins("http://localhost:4200") //ANGULAR
			.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	}
}
