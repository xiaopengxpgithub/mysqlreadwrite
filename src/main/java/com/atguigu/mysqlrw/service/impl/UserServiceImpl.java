package com.atguigu.mysqlrw.service.impl;

import com.atguigu.mysqlrw.mapper.UserMapper;
import com.atguigu.mysqlrw.pojo.User;
import com.atguigu.mysqlrw.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(Integer id) {
        return this.userMapper.getUser(id);
    }

    @Transactional
    @Override
    public int insertUser(User user) {
        logger.info("insert into user!!!");

        return this.userMapper.insertUser(user);
    }

    @Override
    public User findUser(Integer id) {
        return this.userMapper.getUser(id);
    }
}
