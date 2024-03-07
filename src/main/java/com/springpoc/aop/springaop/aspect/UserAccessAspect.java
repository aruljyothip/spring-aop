package com.springpoc.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "com.springpoc.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecutions()")
    public void before(JoinPoint joinPoint){
        logger.info("before intercepting method: {}", joinPoint);
    }

    @After(value = "com.springpoc.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecutions()")
    public  void after(JoinPoint joinPoint){
        logger.info("after intercepting method: {}", joinPoint);
    }

    @AfterReturning(value = "com.springpoc.aop.springaop.aspect.CommonJoinPointConfig.trackTime()",
    returning = "result")
    public  void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("afterReturning intercept method: {} returns {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.springpoc.aop.springaop.aspect.CommonJoinPointConfig.trackTime()",
            throwing = "result")
    public  void afterThrowing(JoinPoint joinPoint, Object result){
        logger.info("afterThrowing intercept method: {} returns {}", joinPoint, result);
    }

    @Around("com.springpoc.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecutions()")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Time taken to execute method {} is {}", joinPoint, (endTime - startTime));
    }
}
