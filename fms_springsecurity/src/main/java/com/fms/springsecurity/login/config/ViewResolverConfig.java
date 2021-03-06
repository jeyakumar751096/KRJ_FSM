package com.fms.springsecurity.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class ViewResolverConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers (ViewResolverRegistry viewResolverRegistry) {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolverRegistry.viewResolver(viewResolver);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure) {
		configure.enable();
		
	}
}
