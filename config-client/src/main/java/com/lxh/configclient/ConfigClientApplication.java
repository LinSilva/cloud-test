package com.lxh.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * User: LinXiaoHui
 * Date: 2018/4/25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigClientApplication.class);
    }
}
