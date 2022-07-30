package com.buimanhthanh.springaop.aspect;
import com.buimanhthanh.springaop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    /*@Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("tony thanhf");
    }

    @Before("execution(* add*(com.buimanhthanh.springaop.model.Account,..))")
    public void thisIsBefore(){
        System.out.println("truoc mat m ne`");
    }*/
    @Before("com.buimanhthanh.springaop.aspect.LogParent.forDaoNoGetterSetter()")
    public void beforeGetAndSet(){
        System.out.println("tao la my demo");
    }
    @AfterReturning(pointcut = "execution(* com.buimanhthanh.springaop.dao.AccountDAO.findAccount(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println(method);
        System.out.println("result = " + result);
    }
}
