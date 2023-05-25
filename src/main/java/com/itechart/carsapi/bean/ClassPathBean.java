package com.itechart.carsapi.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassPathBean extends Bean {
    public ClassPathBean() {
        log.info("-ClassPathBean-: Constructor invoked");
    }

    public void init() {
        log.info("-ClassPathBean-: Initialization.");
    }

    public void destroy() {
        log.info("-ClassPathBean-: Destruction.");
    }
}
