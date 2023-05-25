package com.itechart.carsapi.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FreeBean extends Bean implements InitializingBean, DisposableBean {
    public FreeBean() {
        log.info("-FreeBean-: Constructor invoked");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("-FreeBean-: Initialization.");
    }

    @Override
    public void destroy() {
        log.info("-FreeBean-: Destruction.");
    }
}
