package com.huazi.generator.generator;

import com.huazi.generator.common.util.FileUtil;
import com.huazi.generator.common.util.GeneratorUtil;
import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.database.DatabaseInfo;
import com.huazi.generator.generator.database.dbDataType.DbDataType;
import com.huazi.generator.generator.database.packagemodel.PackageModel;
import com.huazi.generator.generator.model.TableColumns;
import com.huazi.generator.generator.model.XmlResultMap;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

import java.sql.SQLException;
import java.util.*;

public class ServiceImplGenerator {

    private DbDataType m=DbDataType.getInstance();
    GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
    PackageModel packageModel= (PackageModel) SpringUtil.getBean("packageModel");

    public ServiceImplGenerator(String tableName) throws SQLException, ClassNotFoundException {

        //根据表名得到类名 *Entity
        //根据表名得到类名 *Mapper
        String mapperName= GeneratorUtil.getClzName(tableName,"Mapper");
        String lMapperName= GeneratorUtil.underline2Camel(mapperName,true);
        String entityName= GeneratorUtil.getClzName(tableName,"Entity");
        String lEntityName= GeneratorUtil.underline2Camel(entityName,true);
        String serviceName= GeneratorUtil.getClzName(tableName,"Service");
        String serviceImplName= GeneratorUtil.getClzName(tableName,"ServiceImpl");

        String entityPackageName=packageModel.getEntity();
        String mapperPackageName=packageModel.getMapper();
        String servicePackageName=packageModel.getService();
        String serviceImplPackageName=servicePackageName+".impl";

        String entityClz=entityPackageName+"."+entityName;
        String mapperClz=mapperPackageName+"."+mapperName;
        String serviceClz=servicePackageName+"."+serviceName;
        List<String> importList=new ArrayList<>();
        importList.add(entityClz);
        importList.add(mapperClz);
        importList.add(serviceClz);
        importList.add("java.util.*");

        //获取数据库表结构 字段名 字段类型 字段注释
        DatabaseInfo.setColumns(tableName);
        List<TableColumns> list = DatabaseInfo.getTableColumnsList();

        List<XmlResultMap> xmlResultMapList=new ArrayList<>();
        StringBuilder baseColumnSb=new StringBuilder();
        for(TableColumns tableColumn: list){
            XmlResultMap xmlResultMap=new XmlResultMap();
            xmlResultMap.setColumnName(tableColumn.getColumnName());
            String typeStr=m.get(tableColumn.getColumnDataType());
            String[] typeStrs=typeStr.split(":");
            xmlResultMap.setJdbcType(typeStrs[2]);
            xmlResultMap.setAttrName(tableColumn.getAttrName());
            xmlResultMapList.add(xmlResultMap);
            baseColumnSb.append(tableColumn.getColumnName()).append(",");
        }

        String baseColumn=baseColumnSb.toString();
        baseColumn=baseColumn.substring(0,baseColumn.length()-1);
        //获取模板
        Template template=groupTemplate.getTemplate("serviceImpl.btl");

        template.binding("importList",importList);
        template.binding("serviceName", serviceName);
        template.binding("serviceImplName", serviceImplName);
        template.binding("mapperName", mapperName);
        template.binding("lMapperName", lMapperName);

        template.binding("entityName", entityName);
        template.binding("lEntityName", lEntityName);
        template.binding("package", serviceImplPackageName);

        //渲染模板
        String entityStr=template.render();

        /** 获取生成文件路径并输出 */
        String path=GeneratorUtil.getClzPath(serviceImplPackageName.replace(".","\\"),serviceImplName+".java");
        FileUtil.output(path,entityStr);
    }
}
