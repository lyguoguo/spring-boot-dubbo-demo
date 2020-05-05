package com.gly.producer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.gly.api.domain.UserInfo;
import com.gly.api.service.UserService;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo getByUserId(Integer userId) {
        return new UserInfo().setAddress("浙江省杭州市").setAge(18).setName("郭郭").setPhone("15678182354");
    }
}

