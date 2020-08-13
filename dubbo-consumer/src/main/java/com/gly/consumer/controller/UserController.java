package com.gly.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.gly.api.domain.UserInfo;
import com.gly.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

//    @Reference(check = false,retries = 3)
    @Reference
    private UserService userService;

    @GetMapping("/getuserbyid")
    public String getUserById(Integer id){
        log.info("local service traceId:{}", MDC.get("traceId"));
        UserInfo userInfo = userService.getByUserId(id);
        if(null == userInfo){
            return "该用户不存在";
        }
        log.info("remote service traceId:{}",userInfo.getTraceId());
        return JSON.toJSONString(userInfo);
    }
}
