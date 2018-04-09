package com.huazi.generator.generator.dbDataType.impl.mysql;

import com.huazi.generator.generator.dbDataType.DbDataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlDataType  implements DbDataType{
    private Map<String ,String> map=null;

    private static MysqlDataType mysqlDataType=null;
    private MysqlDataType(){
    }

    public static MysqlDataType getInstance(){
        if(mysqlDataType==null){
            synchronized (MysqlDataType.class){
                if(mysqlDataType==null){
                    mysqlDataType=new MysqlDataType();
                }
            }
        }

        return mysqlDataType;
    }

    public void setMap(Map<String ,String> map){
        this.map=map;
    }
    @Override
    public Class<?> get(String dbDataType) throws ClassNotFoundException {
        String javaDataType=map.get(dbDataType);
        Class<?> clz=Class.forName(javaDataType);
        return clz;
    }
}
