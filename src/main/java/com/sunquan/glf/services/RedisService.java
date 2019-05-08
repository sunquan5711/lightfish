package com.sunquan.glf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(String key,Object value){

        try {

            ValueOperations<Serializable, Object> valueOperations =
                    redisTemplate.opsForValue();
            valueOperations.set(key, value);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void getAll(){

    }
}
