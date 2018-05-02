package com.atguigu.mysqlrw.mapper;

import com.atguigu.mysqlrw.pojo.User;

public interface UserMapper {

    User getUser(Integer id);

    int insertUser(User user);
}
