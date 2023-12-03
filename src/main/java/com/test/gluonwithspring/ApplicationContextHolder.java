package com.test.gluonwithspring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
    
	public static <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}

}
