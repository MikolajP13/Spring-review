package com.mp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.mp.aopdemo.dao.*.*(..))")
    public void forDAOPackage() { }

    // create pointcut for getter methods
    @Pointcut("execution(* com.mp.aopdemo.dao.*.get*(..))")
    public void getter() { }

    // create pointcut for setter methods
    @Pointcut("execution(* com.mp.aopdemo.dao.*.set*(..))")
    public void setter() { }

    // create a pointcut include package and exclude getters and setters
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageExcludeGettersSetters() { }
}
