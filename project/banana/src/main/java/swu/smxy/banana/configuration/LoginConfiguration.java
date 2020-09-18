/*
 * @Date: 2020-08-22 21:53:03
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-30 17:49:10
 */
package swu.smxy.banana.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import swu.smxy.banana.interceptor.LoginInterceptor;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer
{
    /**
     * @description: register login interceptor
     * @param {type} 
     * @return {type} 
     */    
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry)
    {
        InterceptorRegistration interceptorRegistration = interceptorRegistry.addInterceptor(new LoginInterceptor());
        // add intercept path
        interceptorRegistration.addPathPatterns("/**"); // add all path

        // add exclude path
        interceptorRegistration.excludePathPatterns(
            "/login",
            "/user/loginService",
            "/",
            "/**/*.html",
            "/**/*.js",
            "/**/*.css",
            "/**/*.png",
            "/**/*.jpg",
            "/**/*.webp",
            "/**/fonts/*"
        );
    }
}