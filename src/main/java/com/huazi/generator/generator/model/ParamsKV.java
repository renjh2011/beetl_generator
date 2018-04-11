package com.huazi.generator.generator.model;

public class ParamsKV {
    /**
     * 实体类名 Vehicle
     */
    private String entityName;
    /**
     * 实体类属性名 vehicle
     */
    private String lEntityName;
    /**
     * 实体类 com.huazi.entity.vehicle
     */
    private String entityClz;
    /**
     * 实体类包路径 com.huazi.entity
     */
    private String entityPackage;

    private String ownPackage;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getlEntityName() {
        return lEntityName;
    }

    public void setlEntityName(String lEntityName) {
        this.lEntityName = lEntityName;
    }

    public String getEntityClz() {
        return entityClz;
    }

    public void setEntityClz(String entityClz) {
        this.entityClz = entityClz;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getOwnPackage() {
        return ownPackage;
    }

    public void setOwnPackage(String ownPackage) {
        this.ownPackage = ownPackage;
    }
}
