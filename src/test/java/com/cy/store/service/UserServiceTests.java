package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("fuck");
            user.setPassword("12345");
            userService.reg(user);
            System.out.println("注册成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("tom22", "123456");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(9,"fuck","12345","123456");
    }

    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(10));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("Apple");
        user.setEmail("243@qq.com");
        user.setGender(0);
        userService.changeInfo(9,"管理员",user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(9,"小明","/upload/test.png");
    }



}

