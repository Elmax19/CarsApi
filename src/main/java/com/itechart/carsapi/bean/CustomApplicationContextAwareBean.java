package com.itechart.carsapi.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public interface CustomApplicationContextAwareBean extends ApplicationContextAware {
    ApplicationContext getContext();
}
