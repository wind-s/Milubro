package com.milu.milubro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public Object hello(){
        return "hello world";
    }


    @RequestMapping("hello2")
    public Object hello2(){
        return "hello world---2";
    }
}
