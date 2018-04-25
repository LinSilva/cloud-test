package com.lxh.client1.module.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: LinXiaoHui
 * Date: 2018/4/24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello," + name + ",this message from server port" + port;
    }
}
