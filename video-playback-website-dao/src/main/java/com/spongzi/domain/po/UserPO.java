package com.spongzi.domain.po;

import lombok.Data;

import java.util.Date;

/**
 * UserPO
 *
 * @author spong
 * @date 2023/11/16
 */
@Data
public class UserPO {

    private Long id;

    private String phone;

    private String email;

    private String password;

    private String salt;

    private Date createTime;

    private Date updateTime;

}
