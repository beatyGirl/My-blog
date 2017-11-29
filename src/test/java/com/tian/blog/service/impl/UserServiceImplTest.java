package com.tian.blog.service.impl;

import com.tian.blog.Application;
import com.tian.blog.entity.User;
import com.tian.blog.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void findUsers() throws Exception {
        List<User> users = userService.findUsers();
        Assert.assertEquals(2, users.size());
    }

}