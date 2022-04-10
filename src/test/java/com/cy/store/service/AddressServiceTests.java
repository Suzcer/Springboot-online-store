package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        Address address=new Address();
        address.setPhone("137923456");
        address.setName("苏致成");
        addressService.addNewAddress(10,"管理员",address);
    }

    @Test
    public void setDefault(){
        addressService.setDefault(4,10,"管理员");
    }

    @Test
    public void delete(){
        addressService.delete(5,10,"管理员");
    }

}

