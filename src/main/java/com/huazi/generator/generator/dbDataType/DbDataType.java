package com.huazi.generator.generator.dbDataType;

import java.util.Map;

public interface DbDataType {
    Class<?> get(String dbDataType) throws ClassNotFoundException;

    void setMap(Map<String ,String> map);
}
