package com.huazi.generator.common.listener;

import org.apache.commons.configuration.PropertiesConfiguration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PropertiesListener implements ServletContextListener {

    public static PropertiesConfiguration SYSTEM;      // 系统配置
    public static PropertiesConfiguration CITY;

    static {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}