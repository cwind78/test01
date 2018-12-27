# test01

create database vuex;

create table user (
id varchar(20),
user_id varchar(20),
pwd varchar(20),
name varchar(20));

# 2018-12-27
create table menu (
id int not null auto_increment primary key, 
lv int, 
sort int,
parent int,
name varchar(20), 
url varchar(100), 
pop_yn varchar(1) default 'N', 
use_yn varchar(1) default 'Y'
);

select *
  from menu;
  
insert into menu (lv, sort, name, url, parent) values (1, 1, '게시판', null, null);
insert into menu (lv, sort, name, url, parent) values (2, 1, '자유게시판', null, 1);
insert into menu (lv, sort, name, url, parent) values (2, 2, '갤러리', null, 1);
insert into menu (lv, sort, name, url, parent) values (3, 1, '자유게시판1', '/board', 2);
insert into menu (lv, sort, name, url, parent) values (3, 2, '갤러리1', '/gallery', 3);
