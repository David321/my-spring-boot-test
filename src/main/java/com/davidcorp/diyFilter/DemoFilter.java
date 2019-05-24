package com.davidcorp.diyFilter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 过滤器是基于AOP实现的

@Component
@WebFilter(urlPatterns = "/index", filterName = "demoFilter")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("我是DemoFilter的init方法");// 项目启动的时候调init()
    }

    @Override
    public void destroy() {
        System.out.println("我是destroy方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("我是DemoFilter的doFilter方法");
        // 获取请求参数

//        request.setAttribute("attr1","changsha");
//        request.removeAttribute("param1");
//        String param1 = request.getParameter("param1");
//        System.out.println("param1="+param1);
//        System.out.println("attr1="+request.getAttribute("attr1"));
        filterChain.doFilter(request, response);
    }
}
