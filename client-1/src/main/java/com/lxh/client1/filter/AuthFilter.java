package com.lxh.client1.filter;

import com.lxh.common.Global;
import com.lxh.common.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: LinXiaoHui
 * Date: 2018/5/3
 */
public class AuthFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader(Global.AUTH_HEADER);
        JWTUtils.JWTResult result = JWTUtils.checkToken(token);
        System.out.println(result.getMsg());
        return result.isStatus();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
