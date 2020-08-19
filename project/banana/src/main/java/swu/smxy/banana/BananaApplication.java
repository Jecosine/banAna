/*
 * @Date: 2020-07-25 03:07:21
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-19 14:05:51
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
public class BananaApplication {

	public static void main(String[] args) {
		// DBConnection.getFactory();
		ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
				System.out.println("beanName: " + beanName);
		}
		SpringApplication.run(BananaApplication.class, args);

	}

}
