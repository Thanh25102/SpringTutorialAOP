package com.buimanhthanh.springaop.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("tony thanhf");
    }

    @Before("execution(* add*(com.buimanhthanh.springaop.model.Account))")
    public void thisIsBefore(){
        System.out.println("truoc mat m ne`");
    }

}
