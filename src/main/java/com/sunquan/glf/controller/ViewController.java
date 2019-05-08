package com.sunquan.glf.controller;

import com.sunquan.glf.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ViewController {

    @RequestMapping("/testredis")
    public String index(HttpServletRequest request){

        String key = "users";
        List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
        Map<String,String> user1 = new HashMap<String, String>();
        user1.put("name","winger");
        user1.put("gender","M");
        user1.put("isLiving","Y");

        Map<String,String> user2 = new HashMap<String, String>();
        user2.put("name","ann");
        user2.put("gender","F");
        user2.put("isLiving","Y");
        userList.add(user1);
        userList.add(user2);


        boolean res = redisService.set(key,userList.toString());
        return "secuss";
    }

    @Autowired
    private RedisService redisService;
}
