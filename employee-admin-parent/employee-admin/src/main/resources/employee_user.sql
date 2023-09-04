create table user
(
    id       int auto_increment
        primary key,
    username varchar(36) null,
    password varchar(36) null,
    enabled  int         null comment '激活(code:1001)'
)
    comment '用户表';

INSERT INTO user (id, username, password, enabled) VALUES (1, 'admin', 'admin', 10011001);