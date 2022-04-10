package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "tim";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }


    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(
                3,"321","管理员",new Date()
        );

    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(3));
    }

    @Test
    public void updateInfoByUid(){
        User user=new User();
        user.setUid(9);
        user.setPhone("18924995651");
        user.setEmail("202@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);

    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(10,
                "/upload/avatar.png",
                "管理员",
                new Date());
    }

}

