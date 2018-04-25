package com.lxh.consumer1.module.core.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: LinXiaoHui
 * Date: 2018/4/24
 */
@FeignClient(name = "client-1")
public interface HelloRemoteService {

    @RequestMapping("/test/hello/{name}")
    String hello(@PathVariable("name") String name);
}
