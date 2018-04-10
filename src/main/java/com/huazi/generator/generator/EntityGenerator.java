package com.huazi.generator.generator;

import com.huazi.generator.common.util.FileUtil;
import com.huazi.generator.common.util.GeneratorUtil;
import com.huazi.generator.common.util.ResourceUtil;
import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.database.DatabaseInfo;
import com.huazi.generator.generator.database.dbDataType.DbDataType;
import com.huazi.generator.generator.database.packagemodel.PackageModel;
import com.huazi.generator.generator.model.TableColumns;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by huazi on 2018/4/9.
 */
public class EntityGenerator implements Generator{
    private DbDataType m=DbDataType.getInstance();

    GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
    PackageModel packageModel= (PackageModel) SpringUtil.getBean("packageModel");
    public EntityGenerator(String tableName) throws SQLException, ClassNotFoundException {

        //根据表名得到类名 *Entity
        String entityName= GeneratorUtil.getClzName(tableName,"Entity");

//        DatabaseInfo databaseInfo=new DatabaseInfo();
        //获取数据库表结构 字段名 字段类型 字段注释
        DatabaseInfo.setColumns(tableName);
        List<TableColumns> list = DatabaseInfo.getTableColumnsList();

        //设置模板参数
        //import set
        Set<String> typeSet = new HashSet<>();
        /** 属性 */
        Map<String,String> attrMap=new HashMap<>();
        /**  get set方法*/
        List<String> listSetMethod=new ArrayList<>(list.size());
        List<String> listGetMethod=new ArrayList<>(list.size());
        for(TableColumns tableColumns : list ){
            String columnName=tableColumns.getAttrName();
            String columnDataType=tableColumns.getColumnDataType();
            String typeAndClz=m.get(columnDataType);
            String[] typeAndClzs=typeAndClz.split(":");
            String type=typeAndClzs[0];
            String clz=typeAndClzs[1];

            attrMap.put(columnName,type);
            typeSet.add(clz);
            StringBuilder setSb=new StringBuilder("public void set");
            setSb.append(tableColumns.getAttrMethod())
                    .append("(").append(type).append(" ").append(columnName).append("){\n")
                    .append("\t\tthis.").append(columnName).append(" = ").append(columnName)
                    .append(";\n\t}");

            listSetMethod.add(setSb.toString());

            StringBuilder getSb=new StringBuilder("public ");
            getSb.append(type).append(" get").append(tableColumns.getAttrMethod())
                    .append("(){\n")
                    .append("\t\treturn this.").append(columnName)
                    .append(";\n\t}");
            listGetMethod.add(getSb.toString());
        }

        //获取模板
        Template template=groupTemplate.getTemplate("entity.btl");

        /** 绑定参数 */
        if(StringUtils.isNotEmpty(packageModel.getEntity())) {
            template.binding("package", "package "+packageModel.getEntity());
        }
        template.binding("attrMap",attrMap);
        template.binding("listImportClz",Arrays.asList(typeSet.toArray()));
        template.binding("listSetMethod",listSetMethod);
        template.binding("listGetMethod",listGetMethod);
        template.binding("entityName",entityName);

        //渲染模板
        String entityStr=template.render();

        /** 获取生成文件路径并输出 */
        String path=GeneratorUtil.getClzPath(packageModel.getEntity().replace(".","/"),entityName+".java");
        FileUtil.output(path,entityStr);
    }
}
