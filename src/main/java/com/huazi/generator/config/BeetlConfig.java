package com.huazi.generator.config;

import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

/**
 * Created by huazi on 2018/4/8.
 */
@org.springframework.context.annotation.Configuration
public class BeetlConfig {
    @Value("${beetl.template.root.path}")
    private String templatePath;

    @Bean("groupTemplate")
    public GroupTemplate groupTemplate() throws IOException {
        String path=BeetlConfig.class.getResource("/").getPath();
        String root = StringUtils.isNotEmpty(templatePath)?
                ( templatePath.startsWith("/")?templatePath:path+templatePath )
                :System.getProperty("user.dir")+ File.separator+"template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
        return groupTemplate;
    }
}
