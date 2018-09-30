package com.kaka.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:/dbconfig.properties")
public class ProfileConfig {



    @Value("${db.user}")
    private String user;

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourcePro() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }



    @Profile("test")
    @Bean
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
