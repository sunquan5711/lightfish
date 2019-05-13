package com.sunquan.glf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {


    @RequestMapping("/user")
    public ModelAndView toUserPage(ModelAndView modelAndView){
        modelAndView.setViewName("userMangement.html");
        return modelAndView;
    }

}
