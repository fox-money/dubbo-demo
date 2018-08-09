package com.hml.dubbo.provider;

import org.itboys.framework.spring.interceptor.ServletContextInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证拦截器
 * Created by weisky on 2016/7/4.
 */
public class SiteIntercepter extends ServletContextInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if(executeTime > 300){
//            HttpRequestTimeService httpRequestTimeService = SpringContextHolder.getBean("httpRequestTimeService");
//            httpRequestTimeService.insert(Constants.TYPE_THREE, executeTime, request.getRequestURI());
//            logger.info("执行请求时间={}，url={}",executeTime, request.getRequestURI());
        }
    }
}
