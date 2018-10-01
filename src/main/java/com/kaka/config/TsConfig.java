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
    �������
        1.�����������
            ����Դ ���ݿ����� springjdbcģ��
        2.��������Դ JdbcTemplate��spring�ṩ�ļ����ݿ�����Ĺ��ߣ�
        3.����������������������� @TransactionManager
        4.@EnableTransactionManagement ��������ע������������
        5.�������ϱ�ע@Transaction ��ʾ��ǰ������һ�����񷽷�


*/


//����ʽ����
@Configuration
@EnableTransactionManagement //��������ע������������
@ComponentScan("com.kaka.tx")
public class TsConfig {


    //����Դ
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

    //�������������
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
