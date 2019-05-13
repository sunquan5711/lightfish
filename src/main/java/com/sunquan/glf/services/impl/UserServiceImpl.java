package com.sunquan.glf.services.impl;

import com.sunquan.glf.constant.DataBaseListKeyName;
import com.sunquan.glf.domain.User;
import com.sunquan.glf.dao.UserDao;
import com.sunquan.glf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    public boolean addUser(User user) {

        return userDao.addUser(user)&&userDao.addUserToTypeList(DataBaseListKeyName.ALL_USER,user);
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
}
