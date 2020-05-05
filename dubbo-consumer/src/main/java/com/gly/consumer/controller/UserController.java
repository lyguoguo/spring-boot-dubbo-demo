package com.gly.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.gly.api.domain.UserInfo;
import com.gly.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Reference(check = false,retries = 3)
    @Reference
    private UserService userService;

    @GetMapping("/getuserbyid")
    public String getUserById(Integer id){
        UserInfo userInfo = userService.getByUserId(id);
        if(null == userInfo){
            return "该用户不存在";
        }
        return JSON.toJSONString(userInfo);
    }
}
