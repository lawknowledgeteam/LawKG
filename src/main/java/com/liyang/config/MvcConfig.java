package com.liyang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Pan
 * @Date: 2019/7/4 18:35
 * @Description:
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射项目静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        //映射 服务器文件
        registry.addResourceHandler("/auvres/user/**").addResourceLocations("file:D:/auvres/user/");
        registry.addResourceHandler("/auvres/scene/**").addResourceLocations("file:D:/auvres/scene/");
        registry.addResourceHandler("/auvres/apk/**").addResourceLocations("file:D:/auvres/apk/");

    }
}
