package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {
    /**
     *  用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    User login(String username,String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     *  根据用户的uid
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    void changeInfo(Integer uid,
                    String username,
                    User user);

    /**
     *  修改用户头像
     * @param uid
     * @param avatar 头像路径
     * @param username 用户名称
     */
    void changeAvatar(Integer uid,
                      String username,
                      String avatar);
}
