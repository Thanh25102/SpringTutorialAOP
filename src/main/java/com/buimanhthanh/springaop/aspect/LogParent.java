package com.buimanhthanh.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogParent {
    @Pointcut("execution(* com.buimanhthanh.springaop.dao.*.get*(..))")
    public void getter(){};
    @Pointcut("execution(* com.buimanhthanh.springaop.dao.*.set*(..))")
    public void setter(){};
    @Pointcut("execution(* com.buimanhthanh.springaop.dao.*.*(..)))")
    public void forDao(){};
    @Pointcut("forDao() && !(getter() || setter())")
    public void forDaoNoGetterSetter(){};
}
