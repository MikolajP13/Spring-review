package com.mp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.mp.aopdemo.aspect.AopExpressions.forDAOPackageExcludeGettersSetters()")
    public void logToCloudAsync() {
        System.out.println("\n=== Async logging to Cloud");
    }
}
