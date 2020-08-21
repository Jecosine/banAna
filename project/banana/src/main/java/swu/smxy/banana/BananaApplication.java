/*
 * @Date: 2020-07-25 03:07:21
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 20:56:02
 * @FilePath: \banana\src\main\java\swu\smxy\banana\BananaApplication.java
 */
package swu.smxy.banana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import swu.smxy.banana.configuration.BeanConfiguration;
import swu.smxy.banana.util.*;

@SpringBootApplication
@MapperScan(basePackages = "swu.smxy.banana.dao")
public class BananaApplication
{

    public static void main(String[] args)
    {
        // DBConnection.getFactory();

        SpringApplication.run(BananaApplication.class, args);

    }

}
