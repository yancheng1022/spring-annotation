package com.kaka.config;


/*
    AOP:[��̬������]���������̣������ڼ䶯̬�Ľ�ĳ�δ������뵽ָ������ָ��λ�ý������еı�̷�ʽ
    1.����aopģ�飺��spring-aspects��
    2.����һ��ҵ���߼��ࣨcalculator������ҵ���߼����е�ʱ����־��ӡ������ǰ����
    3.������־�����ࣨLogAspects��
        ֪ͨ������ǰ��֪ͨ��@Before��
                ����֪ͨ��@After��
                ����֪ͨ��@AfterReturning��
                �쳣֪ͨ��@AfterThrowing��
                ����֪ͨ��@Around��
    4.���������Ŀ�귽����ע��ʱ�ε�����
    5.���������ҵ���߼��඼���뵽������
    6.����spring�ĸ������棨�������ע�⣺@Aspect��
    7.��ǰxml��<aop:aspectj-autoproxy></aop:aspectj-autoproxy>����ע�������湦��
      �������������м��� @EnableAspectJAutoProxy ����ע�������湦��

*/

/*
    AOPԭ��
        1.@EnableAspectJAutoProxy
        2.@Import({AspectJAutoProxyRegistrar.class})�Զ����������ע��bean����AnnotationAwareAspectJAutoProxyRegister



*/

import com.kaka.aop.Calculator;
import com.kaka.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    //ҵ���߼�����뵽����
    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    //����������뵽������
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
