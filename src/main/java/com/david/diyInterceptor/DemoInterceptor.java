package com.david.diyInterceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long start = (Long)request.getAttribute("start");
        request.removeAttribute("start");
        long end = System.currentTimeMillis();
        System.out.println("本次请求处理时间："+new Long(end-start)+"ms");
        request.setAttribute("handlingTime",end-start);
    }
}
