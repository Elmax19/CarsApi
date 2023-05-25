package com.itechart.carsapi.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemBean extends Bean {
    public FileSystemBean() {
        log.info("-FileSystemBean-: Constructor invoked");
    }

    public void init() {
        log.info("-FileSystemBean-: Initialization.");
    }

    public void destroy() {
        log.info("-FileSystemBean-: Destruction.");
    }
}
