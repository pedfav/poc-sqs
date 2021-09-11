package com.pedfav.pocsqs.utils;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpringUtils {

    private final ApplicationContext applicationContext;

    public <T> T getManagedBean(Class<T> requiredType) throws BeansException {
        final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        return beanFactory.getBean(requiredType);
    }

}