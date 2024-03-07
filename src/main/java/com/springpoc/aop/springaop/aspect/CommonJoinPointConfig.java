package com.springpoc.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.springpoc.aop.springaop.data.*.*(..))")
    public void businessLayerExecutions(){
    }

    @Pointcut("@annotation(com.springpoc.aop.springaop.aspect.TrackTime)")
    public void trackTime(){}
}
