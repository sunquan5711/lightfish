package com.sunquan.glf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ViewController {

    @RequestMapping("test")
    public String index(){

        return "seccuess";
    }
}
