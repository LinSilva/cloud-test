package com.lxh.client1.config;

import com.lxh.client1.filter.AuthFilter;
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

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
