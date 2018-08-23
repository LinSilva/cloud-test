package com.lxh.consumer1.config;

import com.lxh.consumer1.filter.AuthFilter;
import com.lxh.consumer1.filter.AuthHeaderFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * User: LinXiaoHui
 * Date: 2018/5/3
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authFilter()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
