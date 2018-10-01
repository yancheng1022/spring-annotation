package com.kaka.tx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("�������...");
        int i = 1/0;
    }
}
