package com.huazi.generator.common.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;

public class PropertiesUtil {
    public static PropertiesConfiguration loadProperties(String propertiesPath,String propertiesName){
        PropertiesConfiguration p=null;
        try {
            p = new PropertiesConfiguration(propertiesPath+propertiesName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return p;
    }
}
