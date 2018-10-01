package com.kaka.tx;

import com.sun.org.apache.xpath.internal.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insert(){
        String sql = "insert into t_user(username,password) values(?,?)";
        jdbcTemplate.update(sql,"yc","123");

    }
}
