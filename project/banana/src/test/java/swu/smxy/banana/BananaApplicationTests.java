/*
 * @Date: 2020-07-25 03:07:21
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 01:06:47
 */
package swu.smxy.banana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.annotation.Resource;

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
class BananaApplicationTests
{
    static ApplicationContext applicationContext;

    @Autowired
    BusinessService bService;
    @Autowired
    UuidGenerator uuidGenerator;
    @Autowired

    @BeforeAll
    static void init()
    {
        System.out.println("before test");
        applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

    @Test
    @DisplayName("Successful get into test")
    void contextLoads()
    {
        System.out.println("in test");
    }

    // /**
    //  * @description: uuid generator test
    //  * @param {type} 
    //  * @return {null} 
    //  */    
    @Test
    @DisplayName("Util:Test uuid")
    void uuidTest()
    {
        for(int i = 1; i <= 32; i++)
        {
            assertEquals(i, UuidGenerator.getUuid(i).length());
        }
    }
    // /**
    //  * @description: java bean test
    //  * @param {type}
    //  * @return {type}
    //  */
    @Test
    @DisplayName("Show all beans")
    void listAllBean()
    {
        System.out.println("Show all available bean.");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames)
        {
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
    //     /**
    //      * @description:
    //      * @param {type}
    //      * @return {type}
    //      */
    //     Business business;

    //     @BeforeAll
    //     void init()
    //     {
    //         System.out.println("  Into nested test");
    //         // business.setBusinessId();
    //     }
    //     // assert
    //     @Test
    //     void test()
    //     {
    //         System.out.println("    test!");
    //     }

    // }

}
