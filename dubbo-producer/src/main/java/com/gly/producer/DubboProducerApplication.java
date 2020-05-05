package com.gly.producer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApplication.class, args);
    }

}
