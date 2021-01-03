package com.aashdit.wcd.web.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aashdit.wcd.*" })
@EnableJpaRepositories(basePackages = {"com.aashdit.wcd.user.repository","com.aashdit.wcd.recruitment.repository", "com.aashdit.wcd.common.repository"})
@EntityScan(basePackages = {"com.aashdit.wcd.user.model","com.aashdit.wcd.recruitment.model", "com.aashdit.wcd.common.model"})
@EnableScheduling
@EnableAutoConfiguration
public class WCDWebApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WCDWebApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WCDWebApplication.class);
    }
	
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*"); 
			}
		}; 
	}
	
}
	