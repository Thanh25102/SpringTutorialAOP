package com.buimanhthanh.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityLogging {
    @Before("com.buimanhthanh.springaop.aspect.LogParent.forDaoNoGetterSetter()")
    public void securityLog(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("tao la security : " + methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
