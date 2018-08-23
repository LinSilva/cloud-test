package com.lxh.zuul1.filter;

import com.lxh.common.Global;
import com.lxh.common.utils.JWTUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * User: LinXiaoHui
 * Date: 2018/5/2
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getHeader(Global.AUTH_HEADER);
        JWTUtils.JWTResult result = JWTUtils.checkToken(token);
        return null;
    }
}
