/*
 * @Date: 2020-08-22 01:55:32
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 02:34:28
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
@DisplayName("User Service Test")
public class UserServiceTest extends BaseServiceTest<User, UserService> {
    public static String cate = "User";
}