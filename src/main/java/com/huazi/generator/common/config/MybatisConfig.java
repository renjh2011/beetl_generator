package com.huazi.generator.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.huazi.generator.common.exception.ExceptionMsg;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(DruidDataSource.class)
public class MybatisConfig {
    @Autowired
    private ExceptionMsg exceptionMsg;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Autowired
    private DataSource druidDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBean.getObject();
        org.apache.ibatis.session.Configuration mybatisConfiguration=sqlSessionFactory.getConfiguration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }

    @Bean
    @ConditionalOnBean(value = SqlSessionFactory.class)
    public SqlSession sqlSession(SqlSessionTemplate sqlSessionTemplate){
        SqlSession sqlSession=sqlSessionTemplate;
        return sqlSession;
    }

    @Bean
    @ConditionalOnBean(value = SqlSessionFactory.class)
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
