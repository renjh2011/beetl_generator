package com.huazi.generator.generator;

import com.huazi.generator.common.util.FileUtil;
import com.huazi.generator.common.util.GeneratorUtil;
import com.huazi.generator.common.util.SpringUtil;
import com.huazi.generator.generator.database.packagemodel.PackageModel;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

import java.sql.SQLException;

public class MapperGenerator {

    GroupTemplate groupTemplate= (GroupTemplate) SpringUtil.getBean("groupTemplate");
    PackageModel packageModel= (PackageModel) SpringUtil.getBean("packageModel");
    public MapperGenerator(String tableName) throws SQLException {
        //根据表名得到类名 *Mapper
        String mapperName= GeneratorUtil.getClzName(tableName,"Mapper");
        String entityName= GeneratorUtil.getClzName(tableName,"Entity");
        String lEntityName= GeneratorUtil.underline2Camel(entityName,true);

        String entityPackageName=packageModel.getEntity();
        String mapperPackageName=packageModel.getMapper();
        String importEntity=entityPackageName+"."+entityName;


        //获取模板
        Template template=groupTemplate.getTemplate("mapper.btl");

        /** 绑定参数 */
        if(StringUtils.isNotEmpty(packageModel.getEntity())) {
            template.binding("package", "package "+mapperPackageName);
        }
        template.binding("mapperName",mapperName);
        template.binding("lEntityName", lEntityName);
        template.binding("importEntity",importEntity);
        template.binding("entityName",entityName);

        //渲染模板
        String entityStr=template.render();

        /** 获取生成文件路径并输出 */
        String path=GeneratorUtil.getClzPath(mapperPackageName.replace(".","/"),mapperName+".java");
        FileUtil.output(path,entityStr);

    }
}
