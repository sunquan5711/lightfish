package com.sunquan.glf.dao;

import com.sunquan.glf.domain.User;
import java.util.List;

public interface UserDao {

    public User getUserById(String userId) throws Exception;

    public boolean addUser(User user) throws Exception;

    public boolean addUserToTypeList(String key,User user) throws Exception;

    public List<User> getUserListByType(String key) throws Exception;
}
