package com.buimanhthanh.springaop.aspect;
import com.buimanhthanh.springaop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());
    /*@Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        myLogger.info("tony thanhf");
    }

    @Before("execution(* add*(com.buimanhthanh.springaop.model.Account,..))")
    public void thisIsBefore(){
        myLogger.info("truoc mat m ne`");
    }*/
    @Before("com.buimanhthanh.springaop.aspect.LogParent.forDaoNoGetterSetter()")
    public void beforeGetAndSet(){
        myLogger.info("tao la my demo");
    }
    @AfterReturning(pointcut = "execution(* com.buimanhthanh.springaop.dao.AccountDAO.findAccount(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // modify result value to UpperCase value
        upperCaseListAccount(result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.buimanhthanh.springaop.dao.AccountDAO.findAccount(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc){
        // print out which method
        String method = joinPoint.getSignature().toShortString();
        myLogger.info(method);

        // log exception
        myLogger.info("Exception "+theExc);
    }

    private void upperCaseListAccount(List<Account> result) {
        result.forEach(account -> {
            account.setName(account.getName().toUpperCase());
        });
    }

    @Around("execution(* com.buimanhthanh.springaop.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        myLogger.info("Duration : " + (end - begin) + "seconds");
        return result;
    }
}
