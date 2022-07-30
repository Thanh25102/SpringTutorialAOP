package com.buimanhthanh.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LogingAPI {
    @Before("com.buimanhthanh.springaop.aspect.LogParent.forDaoNoGetterSetter()")
    public void securityLog(){
        System.out.println("tao la API");
    }
}
