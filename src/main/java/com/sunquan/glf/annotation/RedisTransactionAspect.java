package com.sunquan.glf.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RedisTransactionAspect {

    @Around("@annotation(redisTransaction)")
    public Object around(ProceedingJoinPoint joinPoint, RedisTransaction redisTransaction) throws Throwable {

        logger.info("进入到redis事务切面中");

        boolean res = false;
        try {
            logger.info("开启reids事务");
             redisTemplate.multi();
             res = (Boolean) joinPoint.proceed();


        }catch (Exception e){
            e.printStackTrace();
            logger.info("出现异常，事务回滚");
            redisTemplate.discard();
        }
        System.out.println("这里是执行方法之后");

        if(!res) {
            logger.info("添加失败，回滚事务");
            redisTemplate.discard();
            return res;
        }
        logger.info("添加成功，提交事务");
        redisTemplate.exec();
        return res;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    private static Logger logger = LoggerFactory.getLogger(RedisTransactionAspect.class);

}
