--oracle
		--删除表
drop table scott.account;
create table Account(
	id	 	number(10)	 	primary key,
	username 	 varchar2(20)   not null,
	password 	 varchar2(20)	not null,
	ip			 varchar2(20)	not null,
	logindate	number			 
);

create table account(
id	number	primary key,
username	varchar(10)	not null ,
password	number(10)	not null,
regdate	DATE		
);
create sequence id INCREMENT by 1 start with 0 minvalue 0;


--mysql

create table account(
id	int(4)	primary key auto_increment,
username	varchar(10)	not null ,
password	varchar(10)	not null,
regdate	datetime		
);


drop table scott.student;
create table student(
id         number(10)        primary key,
name		varchar(10)		   not null ,
sex		 number(4)          not null ,
age		 number(4)          not null ,
myclass	varchar(10)         not null ,
address	varchar(20)         not null ,
phone		 number(11)          not null ,
email		varchar(20)         not null
);

--mysql
drop table student;
create table student(
id	int(4)	primary key auto_increment,
name		varchar(10)		   not null ,
sex		 int(4)          not null ,
age		 int(4)          not null ,
myclass	varchar(10)         not null ,
address	varchar(20)         not null ,
phone		 int(11)          not null ,
email		varchar(20)         not null
);


create sequence id INCREMENT by 1 start with 0 minvalue 0;

 DROP SEQUENCE id;

--插入
INSERT INTO account(id,username,password,regdate) values(id.nextval,'aaa',111,sysdate);

--mysql  插入
INSERT INTO account(username,password,regdate) values('aaa',111,now());
INSERT INTO student(name,sex,age,myclass,address,phone,email) values('aaa',1,12,'高级','天津',1233,'@123');
--查找
SELECT DATE_ID,NAME,DESCRIPTION FROM DAPTS WHERE DEPT_ID=1;
select dept_id,name,description from depts;
select dept_id,name,description from depts where name like '% 部 %';
--修改
update depts name=' ',description='' where dept_id= ;
--删除
delete from depts where dept_id= ;



