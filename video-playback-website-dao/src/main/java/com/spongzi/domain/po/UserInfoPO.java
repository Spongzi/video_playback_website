package com.spongzi.domain.po;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息页面
 *
 * @author spong
 * @date 2023/11/16
 */
@Data
public class UserInfoPO {

    private Long id;

    private Long userId;

    private String nick;

    private String avatar;

    private String sign;

    private String gender;

    private String birth;

    private Date createTime;

    private Date updateTime;
}
