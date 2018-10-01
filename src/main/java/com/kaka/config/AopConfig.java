package com.kaka.config;


/*
    AOP:[动态代理技术]面向切面编程，运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
    1.导入aop模块：（spring-aspects）
    2.定义一个业务逻辑类（calculator），在业务逻辑运行的时候将日志打印（方法前，后）
    3.定义日志切面类（LogAspects）
        通知方法：前置通知（@Before）
                后置通知（@After）
                返回通知（@AfterReturning）
                异常通知（@AfterThrowing）
                环绕通知（@Around）
    4.给切入类的目标方法标注何时何地运行
    5.将切面类和业务逻辑类都加入到容器中
    6.告诉spring哪个是切面（切面类加注解：@Aspect）
    7.以前xml中<aop:aspectj-autoproxy></aop:aspectj-autoproxy>开启注解版的切面功能
      现在在配置类中加入 @EnableAspectJAutoProxy 开启注解版的切面功能

*/

/*
    AOP原理：
        1.@EnableAspectJAutoProxy
        2.@Import({AspectJAutoProxyRegistrar.class})自定义给容器中注册bean——AnnotationAwareAspectJAutoProxyRegister



*/

import com.kaka.aop.Calculator;
import com.kaka.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    //业务逻辑类加入到容器
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    //将切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
