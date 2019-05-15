package com.sunquan.glf.services;

import com.sunquan.glf.domain.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user) throws Exception;

    public User getUserById(String userId) throws Exception;

    public List<User> getAllUser() throws Exception;
}
