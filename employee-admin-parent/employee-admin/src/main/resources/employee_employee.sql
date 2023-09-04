create table employee
(
    Id              int auto_increment
        primary key,
    emp_name        varchar(36)          not null,
    sex             int                  not null comment '性别(code:1002)',
    age             int                  not null,
    dept_name       int                  null comment '部门名称(code:1003)',
    emp_degree_name int                  null comment '学历(code:1004)',
    enabled         int default 10011001 null comment '是否激活(code:1001)'
)
    comment '职工表';

INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (1, '23', 10021001, 32, 10031001, 10041002, 10011002);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (2, '的的', 10021001, 32, 10031001, 10041001, 10011002);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (3, '23', 10021002, 32, 10031001, 10041001, 10011002);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (4, '张一', 10021001, 25, 10031001, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (5, '张二', 10021002, 26, 10031003, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (6, '张三', 10021001, 27, 10031002, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (7, '张四', 10021002, 28, 10031003, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (8, '张五', 10021001, 29, 10031002, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (9, '张六', 10021002, 29, 10031002, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (10, '张七', 10021001, 33, 10031001, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (11, '张八', 10021001, 32, 10031001, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (12, '张九', 10021002, 33, 10031001, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (13, '李一', 10021002, 45, 10031001, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (14, '李二', 10021002, 19, 10031003, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (15, '李三', 10021001, 28, 10031001, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (16, '李四', 10021002, 46, 10031002, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (17, '李五', 10021001, 58, 10031001, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (18, '李六', 10021002, 22, 10031003, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (19, '李七', 10021001, 26, 10031002, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (20, '李八', 10021001, 25, 10031003, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (21, '李九', 10021002, 29, 10031002, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (22, '王一', 10021001, 45, 10031002, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (23, '王二', 10021002, 21, 10031001, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (24, '王三', 10021001, 21, 10031001, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (25, '王四', 10021001, 23, 10031001, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (26, '王五', 10021002, 33, 10031001, 10041001, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (27, '王六', 10021001, 45, 10031003, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (28, '王七', 10021001, 35, 10031001, 10041003, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (29, '王八', 10021001, 41, 10031002, 10041002, 10011001);
INSERT INTO employee (Id, emp_name, sex, age, dept_name, emp_degree_name, enabled) VALUES (30, '王九', 10021002, 25, 10031001, 10041001, 10011001);