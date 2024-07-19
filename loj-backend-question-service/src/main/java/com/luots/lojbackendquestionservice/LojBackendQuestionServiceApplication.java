package com.luots.lojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.luots.lojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.luots")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.luots.lojbackendapi.service"})
public class LojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojBackendQuestionServiceApplication.class, args);
    }

}
