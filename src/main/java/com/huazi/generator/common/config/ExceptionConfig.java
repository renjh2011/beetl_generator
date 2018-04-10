package com.huazi.generator.common.config;

import com.huazi.generator.common.exception.ExceptionMsg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfig {
    @Bean
    public ExceptionMsg exceptionMsg(){
        return ExceptionMsg.getInstance();
    }
}
