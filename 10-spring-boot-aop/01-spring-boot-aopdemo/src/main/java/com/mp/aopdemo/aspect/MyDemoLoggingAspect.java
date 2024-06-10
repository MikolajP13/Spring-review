package com.mp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(public void com.mp.aopdemo.dao.AccountDAOImpl.addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(* add*(com.mp.aopdemo.Account))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(* com.mp.aopdemo.dao.*.add*(..))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

//    @Before("execution(* add*(com.mp.aopdemo.Account, ..))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=== Executing @Before on advice on updateAccount()");
//    }

    @Before("execution(* com.mp.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=== Executing @Before on advice on updateAccount()");
    }
}
