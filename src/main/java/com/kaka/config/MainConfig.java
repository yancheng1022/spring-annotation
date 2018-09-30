package com.kaka.config;

import com.kaka.bean.Person;
import com.kaka.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author yc
 * @Date 2018/9/30 9:05
 */
@Configuration
//value:指定要扫描的包
@ComponentScan(value="com.kaka")
public class MainConfig {


    //将bean注入到容器-name默认就是方法名
    //当然也可以自定义（bean的name）
    @Bean(name = "person1")
    /*
        指定作用范围 默认singleton ---单例（ioc容器启动会调用方法将创建的对象放在容器） 可以进行懒加载配置（@lazy）
                      prototype ---多例（每次获取的时候才调用方法创建）
    */

//    @Scope("prototype")
    @Lazy  //懒加载  -针对单例
    @Conditional({WindowsCondition.class})
    public Person person(){
        return new Person("yc", 18);
    }
}
