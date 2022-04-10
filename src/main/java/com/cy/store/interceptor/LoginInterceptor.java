package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测session是否有uid数据，如果有则放行，如果没有重定向到登录页面
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("uid");
        if (obj == null) {//没有登录
            response.sendRedirect("/web/login.html");
            //结束后续的调用
            return false;
        }

        return true;
    }
}
