package com.spongzi.dao;

import com.spongzi.domain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    UserPO getUserByPhone(String phone);

    Integer addUser(UserPO userPO);
}
