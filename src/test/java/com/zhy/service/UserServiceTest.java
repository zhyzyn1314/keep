package com.zhy.service;

import com.zhy.bean.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        Users user = userService.getUserById(1);
        System.out.println(user.toString());
    }
}
