package com.kaka.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

//切面类
@Aspect
public class LogAspects {
    /*
    通知方法中可以声明一个JoinPoint类型的参数。通过JoinPoint可以访问连接点的细节
    */
    //抽取公共的切入点表达式
    @Pointcut("execution(public int com.kaka.aop.Calculator.*(..))")
    public void pointCut(){};

    //在目标方法之前切入
    @Before("pointCut()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法运行前");
    }

    //无论方法正常结束还是异常结束都会返回
    @After("pointCut()")
    public void afterLog(){
        System.out.println("方法运行后");
    }

    @AfterReturning("pointCut()")
    public void returnLog(){
        System.out.println("方法正常返回");
    }

    @AfterThrowing("pointCut()")
    public void exceptionLog(){
        System.out.println("方法抛出异常");
    }
}
