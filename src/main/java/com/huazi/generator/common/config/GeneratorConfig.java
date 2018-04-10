package com.huazi.generator.common.config;

import com.huazi.generator.common.exception.ConfigException;
import com.huazi.generator.common.exception.ExceptionMsg;
import com.huazi.generator.common.util.PropertiesUtil;
import com.huazi.generator.generator.database.dbDataType.DbDataType;
import com.huazi.generator.generator.database.packagemodel.PackageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
public class GeneratorConfig {

    @Value("${generator.database.type}")
    private String dbType;
    @Value("${generator.package.entity}")
    private String entity;

    @Value("${generator.package.mapper}")
    private String mapper;

    @Value("${generator.package.service}")
    private String service;

    @Value("${generator.package.controller}")
    private String controller;

    @Value("${generator.package.xml}")
    private String xml;

    @Bean
    public DbDataType mysqlDataType() throws ConfigException {

        String filename=null;
        switch (dbType){
            case "mysql" : filename = "mysqlDataType.properties";break;
            case "oracle" : filename = "oracleDataType.properties";break;
        }
        if(filename==null){
            throw new ConfigException(1000);
        }
        Map<String ,String > map= PropertiesUtil.loadAll("mysqlDataType.properties");

        DbDataType dbDataType = DbDataType.getInstance();
        dbDataType.setMap(map);
        return dbDataType;
    }

    @Bean
    @Scope(value = "singleton")
    public PackageModel packageModel(){
        PackageModel packageModel=new PackageModel();
        packageModel.setEntity(entity);
        packageModel.setMapper(mapper);
        packageModel.setService(service);
        packageModel.setController(controller);
        packageModel.setXml(xml);
        return packageModel;
    }
}
