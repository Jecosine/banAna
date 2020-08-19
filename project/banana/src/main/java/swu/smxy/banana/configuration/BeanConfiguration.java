/*
 * @Date: 2020-08-19 12:09:27
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 14:05:39
 */
package swu.smxy.banana.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.FilterType;

import swu.smxy.banana.entity.Business;
import swu.smxy.banana.util.DBConnection;

@Configuration
// @ComponentScan(value="swu.smxy.banana")
@ComponentScans(value = {
    @ComponentScan(value = "swu.smxy.banana.entity", 
        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Component.class})},
        useDefaultFilters = false),
    @ComponentScan(value = "swu.smxy.banana.dao", 
        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Mapper.class})},
        useDefaultFilters = false),
    @ComponentScan(value = "swu.smxy.banana.service", 
        includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Service.class})},
        useDefaultFilters = false)}
)
// @MapperScan(value = "swu.smxy.banana.dao")
public class BeanConfiguration {

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory getFactory() 
    {
        return DBConnection.getFactory();
    }
    // @Bean
    // public Business
}