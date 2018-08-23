package com.lxh.zuul1.config;

import com.lxh.zuul1.filter.AuthFilter;
import com.lxh.zuul1.filter.AuthHeaderFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: LinXiaoHui
 * Date: 2018/5/2
 */
@Configuration
public class FilterConfig {

    @Value("${app.clientId}")
    private String clientId;

    @Bean
    public AuthHeaderFilter authHeaderFilter(){
        return new AuthHeaderFilter(clientId);
    }

    @Bean
    public AuthFilter authFilter(){
        return new AuthFilter();
    }
}
