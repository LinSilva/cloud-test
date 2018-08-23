package com.lxh.zuul1;

import com.lxh.common.Global;
import com.lxh.common.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableZuulProxy
public class Zuul1Application {

    @Value("${app.clientId}")
    private String clientId;

    public static void main(String[] args) {
        SpringApplication.run(Zuul1Application.class, args);
    }

    @PostConstruct
    public void init(){
        System.setProperty(clientId, JWTUtils.getToken(clientId));
    }
}
