package com.gly.producer.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.gly.api.domain.UserInfo;
import com.gly.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Service
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo getByUserId(Integer userId) {
        String cId = RpcContext.getContext().getAttachment("traceId");
        return new UserInfo().setAddress("浙江省杭州市").setAge(18).setName("郭郭")
                .setPhone("15678182354").setTraceId(cId);
    }
}

