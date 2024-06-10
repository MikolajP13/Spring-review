package com.mp.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    //setup logger
    private Logger logger  = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.mp.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() { }

    // set up for service and dao
    @Pointcut("execution(* com.mp.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() { }

    @Pointcut("execution(* com.mp.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() { }

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display method name
        this.logger.info(joinPoint.getSignature().toShortString());

        // display the arguments to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            this.logger.info(arg.toString());
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // display method name
        this.logger.info(joinPoint.getSignature().toShortString());

        // display data returned
        this.logger.info(result.toString());
    }
}
