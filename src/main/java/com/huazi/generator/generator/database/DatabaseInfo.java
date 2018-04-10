package com.huazi.generator.generator.database;

import com.huazi.generator.common.util.GeneratorUtil;
import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.Generator;
import com.huazi.generator.generator.model.TableColumns;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huazi on 2018/4/9.
 */
public class DatabaseInfo {
    private static SqlSession sqlSession= (SqlSession) SpringUtil.getBean("sqlSession");
    private static List<TableColumns> tableColumnsList=null;

    /**
     * @describe 根据数据库表名获取对应的列名，数据类型，注释
     * @param tableName
     * @throws SQLException
     */
    public static void setColumns(String tableName) throws SQLException {
        if(tableColumnsList == null){
            synchronized (Generator.class){
                if(tableColumnsList == null) {
                    tableColumnsList = new ArrayList<>();
                }else {
                    return;
                }
            }
        }else {
            return;
        }
//        String statement = " select column_name,data_type,column_comment from information_schema.columns" +
//                            " where table_schema = '"+1+"' and table_name = '"+2+"'";
        String statement = " select column_name,data_type,column_comment from information_schema.columns" +
                " where table_name = '"+tableName+"'";
        Connection connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(statement);
        ResultSet rs =preparedStatement.executeQuery();
        while (rs.next()){
            Map<String,String> map=new HashMap<>();
            String columnName=rs.getString(1);
            String columnDataType=rs.getString(2);
            String columnComment=rs.getString(3);

            String attrName= GeneratorUtil.underline2Camel(columnName,true);
            String columnMethod=GeneratorUtil.capFirst(attrName);
            TableColumns tableColumns=new TableColumns();
            tableColumns.setColumnComment(columnComment);
            tableColumns.setColumnDataType(columnDataType);
            tableColumns.setColumnName(columnName);
            tableColumns.setAttrName(attrName);
            tableColumns.setAttrMethod(columnMethod);
            tableColumnsList.add(tableColumns);
        }
    }

    public static List<TableColumns> getTableColumnsList() {
        return tableColumnsList;
    }
}
