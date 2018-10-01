package com.kaka;

import com.kaka.aop.Calculator;
import com.kaka.bean.Person;
import com.kaka.config.AopConfig;
import com.kaka.config.MainConfig;
import com.kaka.config.TsConfig;
import com.kaka.tx.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        //ͨ�������ļ���ȡbean
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) ac.getBean("person");
//        System.out.println(person);

        //ͨ��config��ȡbean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("person1");
        Person person2 = (Person) applicationContext.getBean("person1");
        //Ĭ���ǵ�����bean
        System.out.println(person == person2);

        //�鿴�����е�����bean
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //spring aop
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = applicationContext1.getBean(Calculator.class);
        calculator.div(1, 1);

        //spring ����
        AnnotationConfigApplicationContext applicationContext3 = new AnnotationConfigApplicationContext(TsConfig.class);
        UserService userService = applicationContext3.getBean(UserService.class);
        userService.insertUser();


    }
}
