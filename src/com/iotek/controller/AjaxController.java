package com.iotek.controller;

import com.iotek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @Autowired
    private User user;
    @RequestMapping("/ajax1")
    public @ResponseBody String ajax1(String key){
        System.out.println(key);
        return "中文";
    }
    @RequestMapping("/ajax2")
    public @ResponseBody User ajax2(String key){

        user.setUserid(1);
        user.setUsername("aaa");
        System.out.println(1);
        return user;
    }
}