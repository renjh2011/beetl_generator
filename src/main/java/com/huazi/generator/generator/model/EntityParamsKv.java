package com.huazi.generator.generator.model;

import java.util.List;
import java.util.Map;

public class EntityParamsKv extends ParamsKV {

    private List<String> listImportClz;
    private Map<String,String> attrMap;
    private List<String> listSetMethod;
    private List<String> listGetMethod;

    public List<String> getListImportClz() {
        return listImportClz;
    }

    public void setListImportClz(List<String> listImportClz) {
        this.listImportClz = listImportClz;
    }

    public Map<String, String> getAttrMap() {
        return attrMap;
    }

    public void setAttrMap(Map<String, String> attrMap) {
        this.attrMap = attrMap;
    }

    public List<String> getListSetMethod() {
        return listSetMethod;
    }

    public void setListSetMethod(List<String> listSetMethod) {
        this.listSetMethod = listSetMethod;
    }

    public List<String> getListGetMethod() {
        return listGetMethod;
    }

    public void setListGetMethod(List<String> listGetMethod) {
        this.listGetMethod = listGetMethod;
    }
}
