package com.huazi.generator.generator.properties;

import com.huazi.generator.common.util.PropertiesUtil;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class DbDataTypeProperties {
    private static String propertiesPath=DbDataTypeProperties.class.getResource("/").getPath();
    public Map<String,String> loadAll(String propertiesName){
        return this.loadAll(DbDataTypeProperties.propertiesPath,propertiesName);
    }

    public Map<String,String> loadAll(String propertiesPath,String propertiesName){
        DbDataTypeProperties.propertiesPath = StringUtils.isNotEmpty(propertiesPath)? propertiesPath: DbDataTypeProperties.propertiesPath;
        PropertiesConfiguration p = PropertiesUtil.loadProperties(propertiesPath,propertiesName);
        Iterator<String> it= p.getKeys();

        Map<String,String> map=new HashMap<>();
        while (it.hasNext()){
            String key=it.next();
            String value=p.getString(key);
            map.put(key,value);
        }
        return map;
    }
}
