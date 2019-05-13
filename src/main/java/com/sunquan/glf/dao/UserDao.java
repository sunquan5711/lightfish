package com.sunquan.glf.dao;

import com.sunquan.glf.domain.User;
import java.util.List;

public interface UserDao {

    public User getUserById(String userId);

    public boolean addUser(User user);

    public boolean addUserToTypeList(String key,User user);

    public List<User> getUserListByType(String key);
}
