package com.fms.springsecurity.login.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[] {WebSecurityConfig.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ViewResolverConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
