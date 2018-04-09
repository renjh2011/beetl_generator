package com.huazi.generator.common.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@Configuration
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
 })
public class DruidStatFilter extends WebStatFilter {

}
