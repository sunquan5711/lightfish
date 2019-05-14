package com.sunquan.glf.annotation;


import java.lang.annotation.*;

/**
 * 加在service层控制redis事务
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface RedisTransaction {


}
