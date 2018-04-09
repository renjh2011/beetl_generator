package com.huazi.generator.common.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MapperScannerConfig implements EnvironmentAware {
    private String mappers;
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(mappers);
        mapperScannerConfigurer.setProcessPropertyPlaceHolders(false);
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        String mappers=environment.getProperty("mybatis.mapper.mappers",String.class);
        this.mappers=mappers;
    }
}
