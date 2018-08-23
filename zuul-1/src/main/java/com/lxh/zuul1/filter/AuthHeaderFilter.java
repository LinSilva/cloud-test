package com.lxh.zuul1.filter;

import com.lxh.common.Global;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * User: LinXiaoHui
 * Date: 2018/5/2
 */
public class AuthHeaderFilter extends ZuulFilter {

    private String clientId;

    public AuthHeaderFilter(String clientId) {
        super();
        this.clientId = clientId;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext.getCurrentContext().addZuulRequestHeader(Global.AUTH_HEADER, System.getProperty(clientId));
        return null;
    }
}
