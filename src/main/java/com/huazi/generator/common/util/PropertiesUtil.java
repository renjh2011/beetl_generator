package com.huazi.generator.common.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PropertiesUtil {
    //classpath路径
    private static String PROPERTIESPATH=PropertiesUtil.class.getResource("/").getPath();

    public static PropertiesConfiguration loadProperties(String propertiesPath,String propertiesName){
        PropertiesConfiguration p=null;
        try {
            p = new PropertiesConfiguration(propertiesPath+propertiesName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 加载文件中所有数据
     * @param propertiesName 文件名
     * @return
     */
    public static Map<String,String> loadAll(String propertiesName){
        return loadAll(PROPERTIESPATH,propertiesName);
    }

    /**
     * 加载文件中所有数据
     * @param propertiesPath 文件路径
     * @param propertiesName 文件名
     * @return
     */
    public static Map<String,String> loadAll(String propertiesPath,String propertiesName){
        if(StringUtils.isEmpty(propertiesPath)){
            return null;
        }
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
