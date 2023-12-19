package com.bryancfz.wishlist.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@ComponentScan(basePackages = {"com.bryancfz.wishlist"})
@SpringBootApplication
public class WishListApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishListApirestApplication.class, args);
	}
	
	/**
	 * Problema de CORS
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

}
