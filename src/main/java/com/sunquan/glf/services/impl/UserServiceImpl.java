package com.sunquan.glf.services.impl;

import com.sunquan.glf.constant.DataBaseListKeyName;
import com.sunquan.glf.domain.User;
import com.sunquan.glf.dao.UserDao;
import com.sunquan.glf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    public boolean addUser(User user) {
        //手动开启事务，这样凑合可以保证原子性，需要将这个方法抽取成通知，我想一想怎么搞
        redisTemplate.multi();
        boolean isSuccess = userDao.addUser(user)&&userDao.addUserToTypeList(DataBaseListKeyName.ALL_USER,user);
        if(!isSuccess){
            redisTemplate.discard();
            return false;
        }
        redisTemplate.exec();
        return true;
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public List<User> getAllUser() {

        List<User> userList = userDao.getUserListByType(DataBaseListKeyName.ALL_USER);

        return userList;
    }


    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;
}
