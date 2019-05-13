package com.sunquan.glf.services;

import com.sunquan.glf.domain.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public User getUserById(String userId);

    public List<User> getAllUser();
}
