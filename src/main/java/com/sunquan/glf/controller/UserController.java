package com.sunquan.glf.controller;

import com.sunquan.glf.domain.User;
import com.sunquan.glf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    @RequestMapping(value = "/add_user")
    public String add_user(HttpServletRequest request){

        User user = User.createUserWithId();
        user.setAge(20);
        user.setDataOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setFirstName("winger");
        user.setLastName("sun");
        user.setPhoneNum("18760274687");

        boolean re = userService.addUser(user);

        if(re)
            return "当前的用户已经增加成功，用户ID是："+user.getUserId();
        else
            return "添加失败";
    }

    @RequestMapping("/getUser/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @Autowired
    private UserService userService;
}
