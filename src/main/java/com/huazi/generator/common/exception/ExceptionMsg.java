package com.huazi.generator.common.exception;

import com.huazi.generator.common.util.PropertiesUtil;

import java.util.Map;

public class ExceptionMsg {
    private static ExceptionMsg exceptionMsg;
    private static Map<String,String> exMap;
    private ExceptionMsg(){
        exMap=PropertiesUtil.loadAll("exception.properties");
    }

    public static ExceptionMsg getInstance(){
        if(exceptionMsg==null){
            synchronized (ExceptionMsg.class){
                if(exceptionMsg==null){
                    exceptionMsg=new ExceptionMsg();
                }
            }
        }
        return exceptionMsg;
    }

    public static Map<String, String> getExMap() {
        return exMap;
    }
}
