/*
 * @Date: 2020-08-22 00:59:48
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 01:22:20
 */
package swu.smxy.banana.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.*;
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
import swu.smxy.banana.service.*;
import swu.smxy.banana.entity.*;
import swu.smxy.banana.util.*;

@SpringBootTest
@DisplayName("Business Service Test")
public class BusinessServiceTest {
    @Autowired
    BusinessService bService;
    /**
     * @description: test businesss service
     * @param {type}
     * @return {type}
     */
    @Test
    @DisplayName("Service: get all test")
    void getAllTest()
    {
        // BusinessService bService = new BusinessService();
        List<Business> businessList = bService.getAll();
        System.out.println("Business count: " + businessList.size());
        // for (Business b : businessList)
        // {
        //     System.out.println("  " + b.toString());
        // }
    }
    @Nested
    @DisplayName("Service: get by id test")
    class curdTest
    {
        List<Business> businessList;
        
        Boolean compare(Business b1, Business b2)
        {
            return b1.toString().equals(b2.toString());
        }
        @BeforeEach
        void init()
        {
            businessList = bService.getAll();
        }
        @Test
        void getByIdTest()
        {
            for(Business b : businessList)
            {
                assertTrue(compare(b, bService.getById(b.getBusinessId())));
            }
        }
        @Test
        void getByNameTest()
        {
            for(Business b : businessList)
            {
                assertTrue(compare(b, bService.getByName(b.getBusinessName())));
            }
        }
    }
}