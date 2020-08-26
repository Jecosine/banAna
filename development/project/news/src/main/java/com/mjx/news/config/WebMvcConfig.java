package com.mjx.news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
  /**
   * 添加静态资源访问路径
   * @param registry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
            // swagger的路径
            .addResourceLocations("classpath:/static/")
            // 用户文件的路径
            .addResourceLocations("file:E:/gdd_videos_files/");
  }
}