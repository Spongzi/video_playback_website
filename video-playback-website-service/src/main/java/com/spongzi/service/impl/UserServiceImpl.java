package com.spongzi.service.impl;

import com.spongzi.dao.UserDao;
import com.spongzi.dao.UserInfoDao;
import com.spongzi.domain.constant.UserConstant;
import com.spongzi.domain.po.UserInfoPO;
import com.spongzi.domain.po.UserPO;
import com.spongzi.exception.ConditionException;
import com.spongzi.service.UserService;
import com.spongzi.util.MD5Util;
import com.spongzi.util.RSAUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 实施用户服务
 *
 * @author spong
 * @date 2023/11/16
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public void addUser(UserPO userPO) {
        String phone = userPO.getPhone();
        if (StringUtils.isBlank(phone)) {
            throw new ConditionException("手机号不能为空");
        }
        UserPO dbUser = this.getUserByPhone(phone);
        if (dbUser != null) {
            throw new ConditionException("该手机号已被注册");
        }
        Date now = new Date();
        String salt = String.valueOf(now.getTime());
        String password = userPO.getPassword();
        String rawPassword;
        try {
            rawPassword = RSAUtil.decrypt(password);
        } catch (Exception e) {
            throw new ConditionException("密码解密失败！");
        }
        String md5Password = MD5Util.sign(rawPassword, salt, "UTF-8");
        userPO.setSalt(salt);
        userPO.setPassword(md5Password);
        userPO.setCreateTime(now);
        userDao.addUser(userPO);
        // 添加用户信息
        UserInfoPO userInfo = new UserInfoPO();
        userInfo.setUserId(userPO.getId());
        userInfo.setNick(UserConstant.DEFAULT_NICK);
        userInfo.setBirth(UserConstant.DEFAULT_BIRTH);
        userInfo.setGender(UserConstant.GENDER_MALE);
        userInfo.setCreateTime(now);
        userInfoDao.addUserInfo(userInfo);
    }

    public UserPO getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }
}
