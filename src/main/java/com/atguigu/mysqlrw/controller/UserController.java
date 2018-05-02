package com.atguigu.mysqlrw.controller;

import com.atguigu.mysqlrw.pojo.User;
import com.atguigu.mysqlrw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 相当于@Controller + @ResponseBody
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/findUser/{id}")
    public User findUser(@PathVariable(value = "id") Integer id){
        return this.userService.findUser(id);
    }


    @RequestMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        return this.userService.getUser(id);
    }

    @RequestMapping(value = "/addUser")
    public String insertUser() {
        try {
            User user = new User();
            user.setName("aa");
            user.setAge(25);
            user.setSex("女");

            int result = this.userService.insertUser(user);
            if (result < 0) {
                // 插入失败
                return "error";
            } else {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
