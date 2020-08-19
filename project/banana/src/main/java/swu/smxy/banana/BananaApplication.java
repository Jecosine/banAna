/*
 * @Date: 2020-07-25 03:07:21
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-26 13:28:20
 * @FilePath: \banana\src\main\java\swu\smxy\banana\BananaApplication.java
 */ 
package swu.smxy.banana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan(basePackages = "swu.smxy.banana.dao")
public class BananaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BananaApplication.class, args);
	}

}
