package com.connect_group.tdd_demo.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration 
@Import({SpringBootTestThymesheetConfig.class})
public class SpringBootTestThymesheetContext extends WebMvcConfigurerAdapter {
	
    @Autowired
    StandardEnvironment environment;
    
    @Bean
    public ServletContext servletContext() {
    	MockServletContext context = new MockServletContext("src/main/resources/templates/", new FileSystemResourceLoader());
    	return context;
    }
}
