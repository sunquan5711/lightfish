package com.sunquan.glf.dao.impl;

import com.sunquan.glf.beans.User;
import com.sunquan.glf.dao.UserDao;
import com.sunquan.glf.support.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Repository
public class UserDaoImpl implements UserDao {

    public User getUserById(String userId) {
        String userJson = (String)valueOperations.get(userId);

        return Support.json2Object(userJson,User.class);
    }

    public boolean addUser(User user) {

        lock.lock();

        try {
            /*
            如果用redis代替关系型数据库，固然有它的优势，但同时弊端也是非常明显的，redis并不能用mysql那种思维模式来考虑数据的存储
            比如有序合理的管理表内容，或者实现根据某个属性查找特定对象数据
            所以完全采用redis做数据库的话，一切都采用纯粹的字符串存储，这样就使得很多复杂关系的查询不能或很难实现
             */
            String userJson = Support.object2Json(user);
            valueOperations.set(user.getUserId(),userJson);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            lock.unlock();
        }

    }

    public boolean addUserToUserList(User user) {

        return false;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

    private ReentrantLock lock = new ReentrantLock();
}
