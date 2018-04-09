package com.huazi.generator.generator.model;

public class TableColumns {
    private String columnName;
    private String columnDataType;
    private String columnComment;

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

    @Override
    public String toString() {
        return "TableColumns{" +
                "columnName='" + columnName + '\'' +
                ", columnDataType='" + columnDataType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
