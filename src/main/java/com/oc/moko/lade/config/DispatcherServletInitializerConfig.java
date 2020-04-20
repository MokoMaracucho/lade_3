package com.oc.moko.lade.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                PersistenceJpaConfig.class
            };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
            };
	}

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }
}
