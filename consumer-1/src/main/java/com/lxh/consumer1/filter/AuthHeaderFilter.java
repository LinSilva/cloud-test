package com.lxh.consumer1.filter;

import com.lxh.common.Global;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * User: LinXiaoHui
 * Date: 2018/5/3
 */
public class AuthHeaderFilter implements RequestInterceptor {

    private String clientId;

    public AuthHeaderFilter(String clientId){
        super();
        this.clientId = clientId;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(Global.AUTH_HEADER, System.getProperty(clientId));
    }
}
