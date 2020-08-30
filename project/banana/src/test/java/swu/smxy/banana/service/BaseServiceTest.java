/*
 * @Date: 2020-08-22 00:59:48
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 03:45:17
 */
package swu.smxy.banana.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

// import org.springframework.test.context.junit4.SpringRunner;
import swu.smxy.banana.configuration.BeanConfiguration;
import swu.smxy.banana.dao.BaseMapper;
import swu.smxy.banana.service.*;
import swu.smxy.banana.entity.*;
import swu.smxy.banana.util.*;

// @Disabled
public class BaseServiceTest<T extends BaseEntity, U extends BaseService<T, ? extends BaseMapper<T> > > {
    @Autowired
    U bService;

    public static String cate = "Entity";
    /**
     * @description: test businesss service
     * @param {type}
     * @return {type}
     */
    @Test
    @DisplayName("Service: get all test")
    void getAllTest()
    {
        // T bService = new T();
        List<T> entityList = bService.getAll();
        System.out.println(cate + " count: " + entityList.size());
        // for (Base b : entityList)
        // {
        //     System.out.println("  " + b.toString());
        // }
    }
    @Nested
    @DisplayName("Service: get by id test")
    @TestInstance(Lifecycle.PER_CLASS)
    class curdTest
    {
        List<T> entityList;
        
        Boolean compare(T b1, T b2)
        {
            System.out.println(b1 + " =?= " + b2);
            return b1.toString().equals(b2.toString());

        }
        @BeforeAll
        void init()
        {
            entityList = bService.getSome(5);
        }
        @Test
        void getByIdTest()
        {
            int i = 0;
            for(T b : entityList)
            {
                ++i;
                assertTrue(compare(b, bService.getById(b.getId())), "At No."+i+":"+b);
            }
        }
        @Test
        void getByNameTest()
        {
            for(T b : entityList)
            {
                assertTrue(compare(b, bService.getByName(b.getName())));
            }
        }
    }
}