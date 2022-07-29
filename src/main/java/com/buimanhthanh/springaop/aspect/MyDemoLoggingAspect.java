package com.buimanhthanh.springaop.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
    /*@Before("execution(* add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("tony thanhf");
    }

    @Before("execution(* add*(com.buimanhthanh.springaop.model.Account,..))")
    public void thisIsBefore(){
        System.out.println("truoc mat m ne`");
    }*/

    @Pointcut("execution(* com.buimanhthanh.springaop.dao.AccountDAO.get*(..))")
    public void getter(){};
    @Pointcut("execution(* com.buimanhthanh.springaop.dao.AccountDAO.set*(..))")
    public void setter(){};
    @Pointcut("execution(* com.buimanhthanh.springaop.dao.*.*(..)))")
    public void forDao(){};

    @Before("forDao() && !(getter() || setter())")
    public void beforeGetAndSet(){
        System.out.println("tao la get set");
    }
}
