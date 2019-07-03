package com.milu.milubro.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("============================拦截器启动==============================");
        request.setAttribute("starttime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        log.info("===========================执行处理完毕=============================");
        long starttime = (long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        log.info("============请求地址："+request.getRequestURI()+"：处理时间：{}",(endtime-starttime)+"ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("============================拦截器关闭==============================");
    }
}
