package com.sunquan.glf.intercepors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RecordIntercepor implements HandlerInterceptor {

    //HandlerInterceptor 接口有三个待实现方法
    //preHandle，postHandle，afterCompletion


    //这个是在访问接口之前执行的
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String addressIP = request.getRemoteAddr();

        System.out.println("这是拦截器里面");

        System.out.println("当前访问者的IP地址是：" + addressIP);
        //TODO 存入日志或数据库
        return addressIP == null ? false : true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
