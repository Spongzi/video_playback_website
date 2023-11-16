create table t_auth_element_operation
(
    id            bigint auto_increment comment '主键id'
        primary key,
    elementName   varchar(255) null comment '页面元素名称',
    elementCode   varchar(50)  null comment '页面元素唯一编码',
    operationType varchar(5)   null comment '操作类型：0可点击  1可见',
    createTime    datetime     null comment '创建时间',
    updateTime    datetime     null comment '更新时间'
)
    comment '权限控制--页面元素操作表' charset = utf8mb4
                                       row_format = DYNAMIC;

create table t_auth_menu
(
    id         bigint auto_increment comment '主键id'
        primary key,
    name       varchar(255) null comment '菜单项目名称',
    code       varchar(50)  null comment '唯一编码',
    createTime datetime     null comment '创建时间',
    updateTime datetime     null comment '更新时间'
)
    comment '权限控制-页面访问表' charset = utf8mb4
                                  row_format = DYNAMIC;

create table t_auth_role
(
    id         bigint auto_increment comment '主键id'
        primary key,
    name       varchar(255) null comment '角色名称',
    code       varchar(50)  null comment '角色唯一编码',
    createTime datetime     null comment '创建时间',
    updateTime datetime     null comment '更新时间'
)
    comment '权限控制--角色表' charset = utf8mb4
                               row_format = DYNAMIC;

create table t_auth_role_element_operation
(
    id                 bigint auto_increment comment '主键id'
        primary key,
    roleId             bigint   null comment '角色id',
    elementOperationId bigint   null comment '元素操作id',
    createTime         datetime null comment '创建时间'
)
    comment '权限控制--角色与元素操作关联表' charset = utf8mb4
                                             row_format = DYNAMIC;

create table t_auth_role_menu
(
    id         bigint auto_increment comment '主键id'
        primary key,
    roleId     bigint   null comment '角色id',
    menuId     bigint   null comment '页面菜单id',
    createTime datetime null comment '创建时间'
)
    comment '权限控制--角色页面菜单关联表' charset = utf8mb4
                                           row_format = DYNAMIC;

create table t_following_group
(
    id         bigint auto_increment comment '主键id'
        primary key,
    userId     bigint      null comment '用户id',
    name       varchar(50) null comment '关注分组名称',
    type       varchar(5)  null comment '关注分组类型：0特别关注  1悄悄关注 2默认分组  3用户自定义分组',
    createTime datetime    null comment '创建时间',
    updateTime datetime    null comment '更新时间'
)
    comment '用户关注分组表' charset = utf8mb4;

create table t_refresh_token
(
    id           bigint auto_increment comment '主键id'
        primary key,
    userId       bigint       null comment '用户id',
    refreshToken varchar(500) null comment '刷新令牌',
    createTime   datetime     null comment '创建时间'
)
    comment '刷新令牌记录表' charset = utf8mb4;

create table t_user
(
    id         bigint auto_increment comment '主键'
        primary key,
    phone      varchar(100) null comment '手机号',
    email      varchar(100) null comment '邮箱',
    password   varchar(255) null comment '密码',
    salt       varchar(50)  null comment '盐值',
    createTime datetime     null comment '创建时间',
    updateTime datetime     null comment '更新时间'
)
    comment '用户表' charset = utf8mb4;

create table t_user_following
(
    id          bigint auto_increment comment '主键id'
        primary key,
    userId      bigint   null comment '用户id',
    followingId int      null comment '关注用户id',
    groupId     int      null comment '关注分组id',
    createTime  datetime null comment '创建时间'
)
    comment '用户关注表' charset = utf8mb4;

create table t_user_info
(
    id         bigint auto_increment comment '主键'
        primary key,
    userId     bigint       null comment '用户id',
    nick       varchar(100) null comment '昵称',
    avatar     varchar(255) null comment '头像',
    sign       text         null comment '签名',
    gender     varchar(2)   null comment '性别：0男 1女 2未知',
    birth      varchar(20)  null comment '生日',
    createTime datetime     null comment '创建时间',
    updateTime datetime     null comment '更新时间'
)
    comment '用户基本信息表' charset = utf8mb4;

create table t_user_moments
(
    id         bigint auto_increment comment '主键id'
        primary key,
    userId     bigint     null comment '用户id',
    type       varchar(5) null comment '动态类型：0视频 1直播 2专栏动态',
    contentId  bigint     null comment '内容详情id',
    createTime datetime   null comment '创建时间',
    updateTime datetime   null comment '更新时间'
)
    comment '用户动态表' charset = utf8mb4;

create table t_user_role
(
    id         bigint auto_increment
        primary key,
    userId     bigint   null comment '用户id',
    roleId     bigint   null comment '角色id',
    createTime datetime null comment '创建时间'
)
    comment '用户角色关联表' charset = utf8mb4
                             row_format = DYNAMIC;

