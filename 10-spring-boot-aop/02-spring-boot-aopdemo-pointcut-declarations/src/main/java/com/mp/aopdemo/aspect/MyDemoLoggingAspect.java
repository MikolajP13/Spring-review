package com.mp.aopdemo.aspect;

import com.mp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.mp.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            System.out.println(e.getMessage());
            // rethrow exception
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // display duration
        System.out.println("Duration : " + (end - begin)/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.mp.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @After on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.mp.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterThrowing on method: " + method);

        System.out.println("Exception: " + exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.mp.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning on method: " + method);
        System.out.println("Result: " + result);

        // post-process the data - convert account names to uppercase
        convertAccountNamesToUppercase(result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.mp.aopdemo.aspect.AopExpressions.forDAOPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=== Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println(account.getName() + " " + account.getLevel());
            }
            System.out.println(arg);
        }
    }
}
