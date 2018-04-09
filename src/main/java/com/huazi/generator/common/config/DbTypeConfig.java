package com.huazi.generator.common.config;

import com.huazi.generator.common.util.PropertiesUtil;
import com.huazi.generator.generator.dbDataType.DbDataType;
import com.huazi.generator.generator.dbDataType.impl.mysql.MysqlDataType;
import com.huazi.generator.generator.properties.DbDataTypeProperties;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.util.*;

@Configuration
public class DbTypeConfig {

    @Value("${generator.database.type}")
    private String dbType;

    @Bean
    public DbDataType mysqlDataType() throws Exception {

        String filename=null;
        DbDataType dbDataType=null;
        switch (dbType){
            case "mysql" : filename = "mysqlDataType.properties";dbDataType = MysqlDataType.getInstance();break;
            case "oracle" : filename = "oracleDataType.properties";break;
        }
        if(filename==null){
            throw new Exception("数据库类型文件不存在");
        }
        DbDataTypeProperties dbDataTypeProperties=new DbDataTypeProperties();
        Map<String ,String > map=dbDataTypeProperties.loadAll("mysqlDataType.properties");
        dbDataType.setMap(map);
        return dbDataType;
    }
}
