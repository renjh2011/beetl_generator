package com.huazi.generator.generator;

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
    public EntityGenerator() throws SQLException, ClassNotFoundException {
        DatabaseInfo databaseInfo=new DatabaseInfo();
        databaseInfo.setColumns("sys_log");
        List<TableColumns> list = databaseInfo.getTableColumnsList();

        Set<String> stringSet = new HashSet<>();
        Map<String,String> map=new HashMap<>();
        List<String> listSetMethod=new ArrayList<>(list.size());
        List<String> listGetMethod=new ArrayList<>(list.size());
        for(TableColumns tableColumns : list ){
            String columnName=tableColumns.getColumnName();
            String columnDataType=tableColumns.getColumnDataType();
            String typeAndClz=m.get(columnDataType);
            String[] typeAndClzs=typeAndClz.split(":");
            String type=typeAndClzs[0];
            String clz=typeAndClzs[1];

            map.put(columnName,type);
            stringSet.add(clz);
            StringBuilder setSb=new StringBuilder("private void set");
            setSb.append(tableColumns.getColumnMethod())
                    .append("(").append(type).append(" ").append(columnName).append("){\n")
                    .append("\t\tthis.").append(columnName).append(" = ").append(columnName)
                    .append(";\n\t}");

            listSetMethod.add(setSb.toString());

            StringBuilder getSb=new StringBuilder("private ");
            getSb.append(type).append(" get").append(tableColumns.getColumnMethod())
                    .append("(){\n")
                    .append("\t\treturn this.").append(columnName)
                    .append(";\n\t}");
            listGetMethod.add(getSb.toString());
        }

        Template template=groupTemplate.getTemplate("test.btl");
        if(StringUtils.isNotEmpty(packageModel.getEntity())) {
            template.binding("package", "package "+packageModel.getEntity());
        }
        template.binding("map",map);
        template.binding("listImportClz",Arrays.asList(stringSet.toArray()));
        template.binding("listSetMethod",listSetMethod);
        template.binding("listGetMethod",listGetMethod);
        template.binding("entityName","SysRoleEntity");
        String s=template.render();
        System.out.println(s);
    }
}
