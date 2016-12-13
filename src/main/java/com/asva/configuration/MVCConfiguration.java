package com.asva.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.asva"}, basePackageClasses=SwaggerConfig.class)
public class MVCConfiguration extends WebMvcConfigurerAdapter{
	/**	
	 * Configure for Swagger
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");
	 
	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    
	    registry.addResourceHandler("/resources/**")
	    	.addResourceLocations("/resources/");
	    
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
	
	/***
	 * Multipart Resolver Configuration
	 * For File Upload
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver(){
		return new CommonsMultipartResolver();
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
				.allowedOrigins("*");
	}
	
}
