package com.capacity.qa.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor{


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //无论如何都放行。具体能不能操作还是在具体的操作中去判断。
        //拦截器只是负责把头请求头中包含token的令牌进行一个解析验证。
        String header = request.getHeader("token");
        System.out.println("-------token----------");
        System.out.println(header);

        return true;
    }
}
