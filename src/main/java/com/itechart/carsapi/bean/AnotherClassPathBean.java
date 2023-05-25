package com.itechart.carsapi.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnotherClassPathBean extends Bean {
    public AnotherClassPathBean() {
        log.info("-AnotherClassPathBean-: Constructor invoked");
    }

    public void init() {
        log.info("-AnotherClassPathBean-: Initialization.");
    }

    public void destroy() {
        log.info("-AnotherClassPathBean-: Destruction.");
    }
}
