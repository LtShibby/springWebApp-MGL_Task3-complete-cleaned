package com.MGL_Task3.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { HibernateConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] { WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

}