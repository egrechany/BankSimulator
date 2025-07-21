package com.example.banksim.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingServiceAspect implements ILoggingService{

    String path;

    @AfterReturning(pointcut = "execution(* com.example.banksim.controller.*(..))",
            returning = "result")
    public void logAfter(Object result){
        System.out.println("Возвращено по запросу: " + result);
    }
}
