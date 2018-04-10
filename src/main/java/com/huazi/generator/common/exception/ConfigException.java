package com.huazi.generator.common.exception;

public class ConfigException extends Exception{
    private int code;
    public ConfigException(int code){
        super();
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
