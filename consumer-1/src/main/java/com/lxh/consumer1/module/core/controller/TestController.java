package com.lxh.consumer1.module.core.controller;

import com.lxh.consumer1.module.core.service.HelloRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: LinXiaoHui
 * Date: 2018/4/24
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private HelloRemoteService helloRemoteService;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return helloRemoteService.hello(name);
    }
}
