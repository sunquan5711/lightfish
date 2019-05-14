package com.sunquan.glf.dao;

import com.sunquan.glf.support.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Repository
public class CommonDao<T> {

    public boolean addEleToTypeList(String listKey, T t){

        try {
            String tJson = Support.object2Json(t);
            redisTemplate.opsForList().leftPush(listKey, tJson);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public <T> List<T> getListByTypeKey(String key){

        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        Long size = listOperations.size(key);

        if(size == 0)
            return null;

        List<T> dataList = new LinkedList<T>();

        for(int i=0;i<size;i++){
            String val = (String) listOperations.index(key,i);
            dataList.add((T)Support.json2Object(val, Object.class));
        }

        return dataList;
    }


    @Autowired
    public  RedisTemplate redisTemplate;

    public ReentrantLock lock = new ReentrantLock();

}
