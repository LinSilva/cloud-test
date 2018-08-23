package com.lxh.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: LinXiaoHui
 * Date: 2018/4/25
 */
@RestController
@RequestMapping
@RefreshScope
public class HelloController {

    @Value("${profile}")
    private String profile;

    @RequestMapping("/hello")
    public String hello(){
        return profile;
    }
}
