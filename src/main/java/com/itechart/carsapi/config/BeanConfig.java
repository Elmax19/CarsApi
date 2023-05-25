package com.itechart.carsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ImportResource("classpath:anotherClassPathContext.xml")
public class BeanConfig {
    @Bean
    public ClassPathXmlApplicationContext classPathContext() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classPathContext.xml");
        classPathXmlApplicationContext.registerShutdownHook();
        return classPathXmlApplicationContext;
    }

    @Bean
    public FileSystemXmlApplicationContext fileSystemContext() {
        FileSystemXmlApplicationContext fileSystemContext = new FileSystemXmlApplicationContext("classpath:fileSystemContext.xml");
        fileSystemContext.registerShutdownHook();
        return fileSystemContext;
    }
}
