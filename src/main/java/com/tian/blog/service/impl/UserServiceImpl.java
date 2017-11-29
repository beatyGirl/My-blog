package com.tian.blog.service.impl;

import com.tian.blog.dao.UserDao;
import com.tian.blog.entity.User;
import com.tian.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }
}
