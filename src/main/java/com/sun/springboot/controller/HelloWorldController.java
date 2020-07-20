package com.sun.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWorldController {


    @RequestMapping({"","/login.html","/","/exit"})
    public String index()
    {
        return "login";
    }
    @RequestMapping({"/sys","/sysexit"})
    public String hello()
    {
        return "syslogin";
    }


//
//    @RequestMapping("/success")
//    public String success(Map<String,Object> map)
//    {
//        map.put("hello","你好");
//        return "success";
//    }
}
