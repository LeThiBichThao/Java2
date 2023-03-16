create database bkacad;
use bkacad;
create table students(
	id varchar(10) primary key,
    full_name varchar(30) not null,
    gender tinyint(1),
    datebirth varchar(20),
    address varchar(50),
    phone varchar(30),
    email varchar(50),
    GPA double
    
);
drop database bkacad;
select * from students;
insert into students values ('ST1','LeBichThao','0','19/10/2001','Bac Giang','013654746','bth@gmail.com','3.1');
insert into students values ('ST2','DoQuangHuy','1','17/01/2001','Ha Noi','013654746','dqh@gmail.com','2.4');