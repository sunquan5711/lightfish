package com.sunquan.glf.dao;


import com.sunquan.glf.beans.User;

import java.util.List;

public interface UserDao {

    public User getUserById(String userId);

    public boolean addUser(User user);

    public boolean addUserToUserList(User user);
}
