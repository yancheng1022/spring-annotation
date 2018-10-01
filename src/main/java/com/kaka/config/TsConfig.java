package com.kaka.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
    环境搭建：
        1.导入相关依赖
            数据源 数据库驱动 springjdbc模块
        2.配置数据源 JdbcTemplate（spring提供的简化数据库操作的工具）
        3.配置事务管理器来管理事务 @TransactionManager
        4.@EnableTransactionManagement 开启基于注解的事务管理功能
        5.给方法上标注@Transaction 表示当前方法是一个事务方法


*/


//声明式事务
@Configuration
@EnableTransactionManagement //开启基于注解的事务管理功能
@ComponentScan("com.kaka.tx")
public class TsConfig {


    //数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //配置事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
