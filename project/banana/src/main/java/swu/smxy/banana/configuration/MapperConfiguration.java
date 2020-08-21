/*
 * @Date: 2020-08-19 12:09:27
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 18:56:03
 */
package swu.smxy.banana.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import swu.smxy.banana.util.DBConnection;

// @Configuration
@ComponentScan(value = "swu.smxy.banana.dao")
public class MapperConfiguration
{
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory getFactory()
    {
        return DBConnection.getFactory();
    }
}