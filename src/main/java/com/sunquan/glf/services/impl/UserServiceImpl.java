package com.sunquan.glf.services.impl;

import com.sunquan.glf.annotation.RedisTransaction;
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


    @RedisTransaction
    public boolean addUser(User user) throws Exception{

        boolean isSuccess = userDao.addUser(user)&&userDao.addUserToTypeList(DataBaseListKeyName.ALL_USER,user);

        return isSuccess;
    }

    public User getUserById(String userId) throws Exception{
        return userDao.getUserById(userId);
    }

    public List<User> getAllUser() throws Exception{

        List<User> userList = userDao.getUserListByType(DataBaseListKeyName.ALL_USER);

        return userList;
    }


    @Autowired
    private UserDao userDao;

}
