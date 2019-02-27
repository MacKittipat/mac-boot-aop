package com.mackittipat.bootaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Execution time = {}", executionTime);
        Arrays.stream(joinPoint.getArgs()).forEach(a -> {
            log.info("Method Args = {}", a.toString());
        });
        log.info("Method Return = {}", proceed.toString());
        log.info("Annotation Param = {}", logExecutionTime.name());
        return proceed;
    }
}
