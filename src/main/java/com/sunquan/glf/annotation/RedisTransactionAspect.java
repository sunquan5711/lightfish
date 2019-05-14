package com.sunquan.glf.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisTransactionAspect {

    @Around("@annotation(redisTransaction)")
    public void around(ProceedingJoinPoint joinPoint, RedisTransaction redisTransaction) throws Throwable {

        System.out.println("这里是切面中的方法");
        joinPoint.proceed();
    }


}
