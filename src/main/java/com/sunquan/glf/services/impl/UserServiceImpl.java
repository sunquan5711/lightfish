package com.sunquan.glf.services.impl;

import com.sunquan.glf.beans.User;
import com.sunquan.glf.dao.UserDao;
import com.sunquan.glf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Autowired
    private UserDao userDao;
}
