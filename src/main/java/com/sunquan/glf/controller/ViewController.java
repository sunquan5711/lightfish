package com.sunquan.glf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
public class ViewController {

    @RequestMapping("/login")
    public String index(HttpServletRequest request){

        return "seccuess";
    }
}
