package com.cs.mvc.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cs.mvc.mybatis.sessionfactory.ScanEnumSessionFactoryBean;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @package: com.cs.mvc.mybatis 
 * @Title: TkMapperConfig 
 * @Description: 配置文件，扫描dao,创建SqlSessionFactory
 * @Company: 诚是创新科技
 * @author llz
 * @date 2018年7月9日 下午2:26:59
 */
@Configuration
@MapperScan(basePackages = "com.cs.dao")
public class TkMapperConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        ScanEnumSessionFactoryBean sessionFactory = new ScanEnumSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setEnumBasePackage("com.cs.common.enums");
        return sessionFactory.getObject();
    }
}