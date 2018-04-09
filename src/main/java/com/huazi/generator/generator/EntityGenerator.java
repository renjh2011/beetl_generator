package com.huazi.generator.generator;

import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.database.DatabaseInfo;
import com.huazi.generator.generator.database.dbDataType.DbDataType;
import com.huazi.generator.generator.model.TableColumns;
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
    public EntityGenerator() throws SQLException, ClassNotFoundException {
        DatabaseInfo databaseInfo=new DatabaseInfo();
        databaseInfo.setColumns("sys_role");
        List<TableColumns> list = databaseInfo.getTableColumnsList();

        Set<String> stringSet = new HashSet<>();
        Map<String,String> map=new HashMap<>();
        for(TableColumns tableColumns : list ){
            String columnName=tableColumns.getColumnName();
            String columnDataType=tableColumns.getColumnDataType();
            String typeAndClz=m.get(columnDataType);
            String[] typeAndClzs=typeAndClz.split(":");
            String type=typeAndClzs[0];
            String clz=typeAndClzs[1];

            map.put(columnName,type);
            stringSet.add(clz);
        }

        Template template=groupTemplate.getTemplate("test.btl");
        template.binding("map",map);
        template.binding("list",Arrays.asList(stringSet.toArray()));
        template.binding("entityName","SysRoleEntity");
        String s=template.render();
        System.out.println(s);
    }
}
