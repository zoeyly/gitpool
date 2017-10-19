drop table scott.account;

create table Account(
	id	 	number(10)	 	primary key,
	username 	 varchar2(20)   not null,
	password 	 varchar2(20)	not null,
	ip			 varchar2(20)	not null,
	logindate	number			 
);

create table Account(
	id	 	int	 	primary key  auto_increment,
	username 	 varchar(20)   not null,
	password 	 varchar(20)	not null,
	ip			 varchar(20)	not null,
	logindate	int			 
);

create sequence id INCREMENT by 1 start with 0 minvalue 0;

 DROP SEQUENCE id;

create sequence seq_acc
increment by 1
start with 1
maxvalue 999999999;

insert into Account(id,username,password,ip,logindate) values(seq_acc.nextval,'admin','admin','127.0.0.1',(SYSDATE - TO_DATE('1970-1-1 8', 'YYYY-MM-DD HH24')) * 86400000 + TO_NUMBER(TO_CHAR(SYSTIMESTAMP(3), 'FF')));

insert into Account(username,password,ip,logindate) values('admin','admin','127.0.0.1',null);

insert into Account(username,password,ip,logindate) values('admin','admin','127.0.0.1',(SYSDATE - TO_DATE('1970-1-1 8', 'YYYY-MM-DD HH24')) * 86400000 + TO_NUMBER(TO_CHAR(SYSTIMESTAMP(3), 'FF')));



