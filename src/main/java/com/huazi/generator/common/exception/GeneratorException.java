package com.huazi.generator.common.exception;

public class GeneratorException extends Exception {
    private int code;
    public GeneratorException(int code){
        super();
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
