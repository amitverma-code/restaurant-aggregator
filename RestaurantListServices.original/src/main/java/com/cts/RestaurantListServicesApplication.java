package com.cts;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class RestaurantListServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantListServicesApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
			    .apis(RequestHandlerSelectors.basePackage("com.cts"))
			    .build()
			    .apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Restaurant Services",
				"Sample API for providing Restaurant Services",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Rajneesh Yadav", "www.cognizant.com", "844300@cognizant.com"),
				"API License",
				"http://cognizant.com",
				Collections.emptyList());
		
	}
}
