package com.tian.blog.dao;

import com.tian.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findUsers();
}
