package com.huazi.generator.common.config;

import com.huazi.generator.generator.database.dbDataType.DbDataType;
import com.huazi.generator.generator.database.packagemodel.PackageModel;
import com.huazi.generator.generator.properties.DbDataTypeProperties;
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

    @Bean
    public DbDataType mysqlDataType() throws Exception {

        String filename=null;
        switch (dbType){
            case "mysql" : filename = "mysqlDataType.properties";break;
            case "oracle" : filename = "oracleDataType.properties";break;
        }
        if(filename==null){
            throw new Exception("数据库类型文件不存在");
        }
        DbDataTypeProperties dbDataTypeProperties=new DbDataTypeProperties();
        Map<String ,String > map=dbDataTypeProperties.loadAll("mysqlDataType.properties");

        DbDataType dbDataType = DbDataType.getInstance();
        dbDataType.setMap(map);
        return dbDataType;
    }

    @Bean
    @Scope(value = "singleton")
    public PackageModel packageModel(){
        PackageModel packageModel=new PackageModel();
        packageModel.setEntity(entity);
        return packageModel;
    }
}
