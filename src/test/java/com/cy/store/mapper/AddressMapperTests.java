package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

    @Autowired
    AddressMapper addressMapper;

    @Test
    public void countById(){
        System.out.println(addressMapper.countByUid(9));
    }

    @Test
    public void insert(){
        Address address=new Address();
        address.setUid(9);
        address.setPhone("213456");
        address.setName("牛牛子");
        addressMapper.insert(address);
    }

    @Test
    public void findByUid(){
        List<Address> list = addressMapper.findByUid(10);
        System.out.println(list);//list重写了toString方法
    }

    @Test
    public void findByAid(){
        Address address = addressMapper.findByAid(5);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(10);
    }

    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(5,"mimi",new Date());
    }

    @Test
    public void deleteByAid(){
        addressMapper.deleteByAid(1);
    }

    @Test
    public void findLastModified(){
        System.out.println(addressMapper.findLastModified(10));
    }

}
