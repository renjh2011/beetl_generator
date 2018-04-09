package com.huazi.generator.generator.database.dbDataType;

import java.util.Map;

public class DbDataType {
    private Map<String ,String> map=null;

    private static DbDataType dbDataType=null;
    private DbDataType(){
    }

    public static DbDataType getInstance(){
        if(dbDataType==null){
            synchronized (DbDataType.class){
                if(dbDataType==null){
                    dbDataType=new DbDataType();
                }
            }
        }
        return dbDataType;
    }

    public synchronized void setMap(Map<String ,String> map){
        if(this.map==null)
            this.map=map;
    }
    public String get(String dbDataType) throws ClassNotFoundException {
        return map.get(dbDataType);
    }
}
