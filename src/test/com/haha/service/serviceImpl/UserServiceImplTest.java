package com.haha.service.serviceImpl;

import com.haha.model.User;
import com.haha.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userServiceImpl;

    @Test
    public void selectByUserName() {
//        System.out.println("af");
        String s  = userServiceImpl.selectByUserName("admin", "admin");
//        System.out.println(user.getEmail());
    }

    @Test
    public void insert() {
        User record = new User();
        record.setUsername(null);
        record.setStatus(false);
        record.setPassword("da");
        record.setEmail("1362s19sdfa58447@163.com");
        System.out.println(userServiceImpl.insert(record));
    }
}