package com.mysport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MySportApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySportApplication.class, args);
	}

//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
//						.allowCredentials(true);
//				;
//			}
//		};
//	}

}
