package com.huazi.generator.generator.model;

public class TableColumns {
    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String columnDataType;

    /**
     * 字段注释
     */
    private String columnComment;

    /**
     * 根据字段名生成方法名
     */
    private String attrMethod;

    private String attrName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnDataType() {
        return columnDataType;
    }

    public void setColumnDataType(String columnDataType) {
        this.columnDataType = columnDataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrMethod() {
        return attrMethod;
    }

    public void setAttrMethod(String attrMethod) {
        this.attrMethod = attrMethod;
    }

    @Override
    public String toString() {
        return "TableColumns{" +
                "columnName='" + columnName + '\'' +
                ", columnDataType='" + columnDataType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
