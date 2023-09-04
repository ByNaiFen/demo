create table code
(
    id        int         not null
        primary key,
    type      int         null,
    type_name varchar(36) null,
    type_desc varchar(36) null
)
    comment '码表';

create index code_type_index
    on code (type);

INSERT INTO code (id, type, type_name, type_desc) VALUES (10011001, 1001, '是否激活', '是');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10011002, 1001, '是否激活', '否');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10021001, 1002, '性别', '男');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10021002, 1002, '性别', '女');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10031001, 1003, '部门名称', '业务部');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10031002, 1003, '部门名称', '后勤部');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10031003, 1003, '部门名称', '人事部');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10041001, 1004, '学历', '大专');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10041002, 1004, '学历', '本科');
INSERT INTO code (id, type, type_name, type_desc) VALUES (10041003, 1004, '学历', '研究生');