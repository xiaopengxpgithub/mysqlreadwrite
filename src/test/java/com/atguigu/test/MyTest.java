package com.atguigu.test;

import com.atguigu.mysqlrw.pojo.User;
import com.atguigu.mysqlrw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void test2(){
        User user=this.userService.getUser(8);
        System.out.println(user.toString());
    }

    @Test
    public void test() {
        User user = new User();
        user.setName("cc");
        user.setAge(22);
        user.setSex("男");

        this.userService.insertUser(user);
    }
}
