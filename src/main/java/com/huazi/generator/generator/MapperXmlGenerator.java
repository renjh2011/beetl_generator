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
import java.util.ArrayList;
import java.util.List;

public class MapperXmlGenerator {
    private DbDataType m=DbDataType.getInstance();
    private GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
    private PackageModel packageModel= (PackageModel) SpringUtil.getBean("packageModel");
    public MapperXmlGenerator(String tableName) throws SQLException, ClassNotFoundException {
        //根据表名得到类名 *Mapper
        String mapperName= GeneratorUtil.getClzName(tableName,"Mapper");
        String entityName= GeneratorUtil.getClzName(tableName,"Entity");

        String entityPackageName=packageModel.getEntity();
        String mapperPackageName=packageModel.getMapper();
        String xmlPath=packageModel.getXml();

        String entityClz=entityPackageName+"."+entityName;
        String mapperClz=mapperPackageName+"."+mapperName;

        //获取数据库表结构 字段名 字段类型 字段注释
        DatabaseInfo databaseInfo=new DatabaseInfo(tableName);
        List<TableColumns> list = databaseInfo.getTableColumnsList();

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
        Template template=groupTemplate.getTemplate("mapperxml.btl");

        template.binding("entityClz",entityClz);
        template.binding("mapperClz", mapperClz);
        template.binding("resultMapList", xmlResultMapList);
        template.binding("baseColumn", baseColumn);
        template.binding("tableName", tableName);

        //渲染模板
        String entityStr=template.render();

        /** 获取生成文件路径并输出 */
        String path=GeneratorUtil.getResourcePath(xmlPath,mapperName+".xml");
        FileUtil.output(path,entityStr);

    }
}
