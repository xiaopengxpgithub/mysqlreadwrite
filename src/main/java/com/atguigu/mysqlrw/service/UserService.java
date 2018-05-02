package com.atguigu.mysqlrw.service;

import com.atguigu.mysqlrw.annotation.TargetDataSource;
import com.atguigu.mysqlrw.pojo.User;

public interface UserService {

    @TargetDataSource(value = "read")
    User getUser(Integer id);

    @TargetDataSource(value = "write")
    int insertUser(User user);

    // 没有添加注解,使用默认的数据源
    User findUser(Integer id);
}
