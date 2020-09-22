/*
 * @Date: 2020-09-22 15:27:40
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-22 15:35:55
 */
package swu.smxy.banana.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer
{
    @Value("${banana.upload.path}")
    public String uploadPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/file/**").addResourceLocations("file:" + uploadPath);
    }
}