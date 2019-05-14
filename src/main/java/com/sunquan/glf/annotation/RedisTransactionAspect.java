package com.sunquan.glf.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RedisTransactionAspect {

    @Around("@annotation(redisTransaction)")
    public Object around(ProceedingJoinPoint joinPoint, RedisTransaction redisTransaction) throws Throwable {

        logger.info("test");
        System.out.println("这里是切面中的方法");
        Object res = joinPoint.proceed();
        System.out.println("这里是执行方法之后");
        return res;
    }

    private static Logger logger = LoggerFactory.getLogger(RedisTransactionAspect.class);

}
