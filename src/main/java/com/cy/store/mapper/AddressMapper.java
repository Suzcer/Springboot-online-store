package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AddressMapper {

    /**
     *  插入用户的收货地址数据
     * @param address
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     *  根据用户的id统计地址数量
     * @param uid
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);

    /**
     *  根据uid查询收货地址数据
     * @param uid
     * @return
     */
    List<Address> findByUid(Integer uid);

    /**
     *  根据aid查询收货地址数据
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    /**
     *  根据用户的uid值来修改用户的收货地址设置为非默认
     * @param uid
     * @return
     */
    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    /**
     *  根据id删除收货地址数据
     * @param aid
     * @return
     */
    Integer deleteByAid(Integer aid);

    /**
     *
     * @param uid
     * @return
     */
    Address findLastModified(Integer uid);

}
