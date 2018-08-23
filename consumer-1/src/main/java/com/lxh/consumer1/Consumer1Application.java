package com.lxh.consumer1;

import com.lxh.common.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer1Application {

    @Value("${app.clientId}")
    private String clientId;

    public static void main(String[] args) {
        SpringApplication.run(Consumer1Application.class, args);
    }

    @PostConstruct
    public void init(){
        System.setProperty(clientId, JWTUtils.getToken(clientId));
    }
}
