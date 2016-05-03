package com.connect_group.tdd_demo.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.templatemode.ITemplateModeHandler;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.connect_group.tdd_demo.config.thymesheet.SpringBootTestTemplateModeHandler;
import com.connect_group.tdd_demo.thymeleaf.TddDemoDialect;
import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;

@Configuration
public class SpringBootTestThymesheetConfig extends SpringBootThymesheetConfig {
	
	@Autowired ServletContext servletContext;
	@Autowired ApplicationContext applicationContext;
	
	private static final Logger log = Logger.getLogger(SpringBootTestThymesheetConfig.class);
	
	@Bean
	public ThymeleafTestEngine selectorEngine() {
		if (log.isInfoEnabled()) {
			log.info("ThymeleafDemoTestConfig.selectorEngine() invoked");
		}
		
		ThymeleafTestEngine engine = new ThymeleafTestEngine();
		
		Set<ITemplateModeHandler> templateModeHandlers = new HashSet<>();
		SpringBootTestTemplateModeHandler templateModeHandler = new SpringBootTestTemplateModeHandler();
		templateModeHandler.setServletContext(servletContext);
		templateModeHandlers.add(templateModeHandler);
		engine.setTemplateModeHandlers(templateModeHandlers);

		Set<ITemplateResolver> templateResolvers = new HashSet<>();
		templateResolvers.add(templateResolver());
		templateResolvers.add(fileTemplateResolver());
		
		engine.setTemplateResolvers(templateResolvers);
		
		Set<IDialect> additionalDialects = new HashSet<>();
		additionalDialects.add(new TddDemoDialect());
		engine.setAdditionalDialects(additionalDialects);
		
		engine.setServletContext(servletContext);
		engine.setApplicationContext(applicationContext);
		return engine;
	}
		
	private FileTemplateResolver fileTemplateResolver() {
		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setPrefix("src/main/resources/templates/");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateMode("HTML5");
		resolver.setCacheable(false);
		resolver.setOrder(2);
		return resolver;
	}
}
