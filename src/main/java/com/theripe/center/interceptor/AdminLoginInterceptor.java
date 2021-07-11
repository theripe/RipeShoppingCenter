package com.theripe.center.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author TheRipe
 * @create 2021/6/24 20:26
 */
//后台管理系统登录拦截
    @Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String requestServletPath = request.getServletPath();
       if (requestServletPath.startsWith("/admin") && request.getSession().getAttribute("loginUser") == null) {
           response.sendRedirect(request.getContextPath()+"/admin/login");
           return false;
       } else {
           request.getSession().removeAttribute("errorMsg");
           return true;
       }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
