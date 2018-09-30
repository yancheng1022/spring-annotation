package com.kaka;

import com.kaka.bean.Person;
import com.kaka.config.MainConfig;
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




    }
}
