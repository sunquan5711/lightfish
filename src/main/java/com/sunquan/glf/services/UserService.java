package com.sunquan.glf.services;

import com.sunquan.glf.beans.User;

public interface UserService {

    public boolean addUser(User user);

    public User getUserById(String userId);
}
