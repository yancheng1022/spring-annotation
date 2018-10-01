package com.kaka.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

//������
@Aspect
public class LogAspects {
    /*
    ֪ͨ�����п�������һ��JoinPoint���͵Ĳ�����ͨ��JoinPoint���Է������ӵ��ϸ��
    */
    //��ȡ�������������ʽ
    @Pointcut("execution(public int com.kaka.aop.Calculator.*(..))")
    public void pointCut(){};

    //��Ŀ�귽��֮ǰ����
    @Before("pointCut()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"��������ǰ");
    }

    //���۷����������������쳣�������᷵��
    @After("pointCut()")
    public void afterLog(){
        System.out.println("�������к�");
    }

    @AfterReturning("pointCut()")
    public void returnLog(){
        System.out.println("������������");
    }

    @AfterThrowing("pointCut()")
    public void exceptionLog(){
        System.out.println("�����׳��쳣");
    }
}
