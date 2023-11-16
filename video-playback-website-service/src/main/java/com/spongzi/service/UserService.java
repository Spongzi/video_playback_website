package com.spongzi.service;

import com.spongzi.domain.po.UserPO;

/**
 * 用户服务
 *
 * @author spong
 * @date 2023/11/16
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param userPO 用一点
     */
    void addUser(UserPO userPO);
}
