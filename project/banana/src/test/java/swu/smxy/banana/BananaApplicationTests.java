/*
 * @Date: 2020-07-25 03:07:21
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-26 23:59:49
 */
package swu.smxy.banana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolutionException;
// import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
// import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;


// import org.springframework.test.context.junit4.SpringRunner;
import swu.smxy.banana.configuration.BeanConfiguration;
import swu.smxy.banana.service.*;
import swu.smxy.banana.entity.*;
import swu.smxy.banana.util.*;

@SpringBootTest
class BananaApplicationTests {
    static ApplicationContext applicationContext;

    @Autowired
    BusinessService bService;
    @Autowired
    UuidGenerator uuidGenerator;

    @Autowired

    @BeforeAll
    static void init() {
        System.out.println("before test");
        applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

    @Test
    public void testHelloworld() {
        // 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        // 2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            // 4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5、身份验证失败
        }
        assertEquals(true, subject.isAuthenticated()); // 断言用户已经登录
        // 6、退出
        subject.logout();
    }

    @Test
    @DisplayName("Successful get into test")
    void contextLoads() {
        System.out.println("in test");
    }

    /**
     * @description: uuid generator test
     * @param {type}
     * @return {null}
     */
    @Test
    @DisplayName("Util:Test uuid")
    void uuidTest() {
        for (int i = 1; i <= 32; i++) {
            assertEquals(i, UuidGenerator.getUuid(i).length());
        }
    }

    /**
     * @description: java bean test
     * @param {type}
     * @return {type}
     */
    @Test
    @DisplayName("Show all beans")
    void listAllBean() {
        System.out.println("Show all available bean.");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("  beanName: " + beanName);
        }
    }

    /**
     * @description: test database connection
     */
    // @Transactional
    // @DisplayName("Database:Test database connection")
    // class databaseConnectionTest
    // {
    // /**
    // * @description:
    // * @param {type}
    // * @return {type}
    // */
    // Business business;

    // @BeforeAll
    // void init()
    // {
    // System.out.println(" Into nested test");
    // // business.setBusinessId();
    // }
    // // assert
    // @Test
    // void test()
    // {
    // System.out.println(" test!");
    // }

    // }

}
