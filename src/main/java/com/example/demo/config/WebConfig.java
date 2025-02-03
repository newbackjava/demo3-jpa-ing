package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//static아래 넣어야지 브라우저에 보인다.
//static폴더는 프로젝트 시작하고 변경하면 XXXXX
//파일첨부한 후 첨부파일을 다이나믹하게 upload에 저장할 예정임.
//이 폴더만 다이나믹하게 사용할 예정이라고 등록해야함.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/static/upload/");
    }
}