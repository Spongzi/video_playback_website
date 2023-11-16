package com.spongzi.dao;

import com.spongzi.domain.po.UserInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

    /**
     * 添加用户信息
     *
     * @param userInfo 用户信息
     */
    void addUserInfo(UserInfoPO userInfo);
}
