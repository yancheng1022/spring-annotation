package com.kaka;

import com.kaka.aop.Calculator;
import com.kaka.bean.Person;
import com.kaka.config.AopConfig;
import com.kaka.config.MainConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        //通过配置文件获取bean
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) ac.getBean("person");
//        System.out.println(person);

        //通过config获取bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("person1");
        Person person2 = (Person) applicationContext.getBean("person1");
        //默认是单例的bean
        System.out.println(person == person2);

        //查看容器中的所有bean
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = applicationContext1.getBean(Calculator.class);
        calculator.div(1, 1);


    }
}
