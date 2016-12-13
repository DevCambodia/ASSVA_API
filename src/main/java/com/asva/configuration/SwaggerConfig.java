package com.asva.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.asva.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
	
	private ApiInfo apiInfo() {
	    @SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(
	      "ASVA REST API",
	      "Provide api for news.",
	      "API TOS",
	      "Terms of service",
	      "sovathanalun@gmail.com",
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}
}
