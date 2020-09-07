/*
 * @Date: 2020-08-19 12:09:27
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 21:46:25
 */
package swu.smxy.banana.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.FilterType;

import swu.smxy.banana.entity.Business;
import swu.smxy.banana.util.DBConnection;

@Configuration
// @ComponentScan(value="swu.smxy.banana")
@ComponentScans(value =
{
    @ComponentScan(value = "swu.smxy.banana.entity", includeFilters =
    { @Filter(type = FilterType.ANNOTATION, classes =
            { Component.class }) }, useDefaultFilters = false),
    @ComponentScan(value = "swu.smxy.banana.dao", includeFilters =
    { @Filter(type = FilterType.ANNOTATION, classes =
    { Mapper.class }) }, useDefaultFilters = false),
    @ComponentScan(value = "swu.smxy.banana.service", includeFilters =
    { @Filter(type = FilterType.ANNOTATION, classes =
    { Service.class }) }, useDefaultFilters = false),
    @ComponentScan(value = "swu.smxy.banana.util", includeFilters =
    { @Filter(type = FilterType.ANNOTATION, classes =
    { Component.class }) }, useDefaultFilters = false) 
})
// @MapperScan(value = "swu.smxy.banana.dao")
public class BeanConfiguration
{

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory getFactory()
    {
        return DBConnection.getFactory();
    }
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer()
    {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                // factory.setPort(8081);
                factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html"));            
                factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));            
                factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            }
        };
    }
}