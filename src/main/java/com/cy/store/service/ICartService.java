package com.cy.store.service;

import com.cy.store.VO.CartVO;

import java.util.List;

/** 处理商品数据的业务层接口 */
public interface ICartService {
    /**
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param pid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    List<CartVO> getVOByUid(Integer id);


    /**
     *  更新用户的购物车数据数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid,Integer uid,String username);

    /**
     *  更新用户的购物车数据
     * @param cid
     * @param uid
     * @param username
     * @return 减少成功后新的数据
     */
    Integer minusNum(Integer cid,Integer uid,String username);


    List<CartVO> getVOByCid(Integer uid,Integer[] cids);
}