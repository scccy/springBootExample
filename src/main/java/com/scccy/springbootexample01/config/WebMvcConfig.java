package com.scccy.springbootexample01.config;

import com.scccy.springbootexample01.handlerInterceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//         添加拦截器，并指定拦截的路径
//        指定拦截目标
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/user/login") // 指定拦截器的URL路径匹配模式
//                .excludePathPatterns("/login", "/register") // 指定不拦截的路径，如登录或注册页面
        ;
    }
}
