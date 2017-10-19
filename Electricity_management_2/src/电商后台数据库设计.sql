create database business ;
use business;
-- ��Ʒ��
create table product(
   id          int          primary key  auto_increment,-- ��Ʒ��ţ�����
   pname       varchar(20)  not null,
   cid         int  ,-- �����������cate���е�cid
   pno         varchar(30)  ,-- ����
   pic         varchar(100),-- ��ƷͼƬ
   price       double     , -- ��Ʒ�۸�
   online      int     ,   -- 1:����  0:���� 
   pdetail     text       -- ��Ʒ����
);

-- ����
 create table Cate(
  cid        int           primary key  auto_increment, -- ���id��
  cname      varchar(20)   not null,	-- �������
  pid        int          -- ��Ʒid��
  
 );

-- ����
create table rule(

  id            int      primary key  auto_increment ,
  pid           int     ,-- ��Ʒid��������Ʒ���е�id
  size          varchar(20)  -- �ߴ�
);
 

-- ��Ա��
-- ����ʺ���Ϣ
 create table account_consumer(
    id         int       primary key auto_increment,
    loginname   varchar(50)  not null,
    password   varchar(50) ,
    registertime   bigint    ,-- ע��ʱ��
    lastlogintime   bigint,-- ����¼ʱ��
    ip          varchar(20)-- ip��ַ
 
 );
-- ��ҹ�����Ϣ
create table  shoppinginfo_consumer(
   id          int      primary key auto_increment,
   aid         int     ,-- ����ʺ�id������account_consumer���е�id
   nickname    varchar(20) ,-- �û��ǳ�
   money       double  ,-- �������
   lasttime        bigint  -- �������  
);
 
 


-- ����
  -- �����ʺ���Ϣ
 create table account_product(
    id         int       primary key auto_increment,
    loginname   varchar(50)  not null,
    password   varchar(50) ,
    registertime   bigint    ,-- ע��ʱ��
    lastlogintime   bigint,-- ����¼ʱ��
    ip          varchar(20)-- ip��ַ
 );
 
 
 

 
 -- ��ַ��,���ͻ�ѡ��
 create table  address(
   
    id         int           primary key  auto_increment,
    province   varchar(20)   not null ,-- ʡ��
    city       varchar(40)   not null ,-- ����
    area        varchar(40)    not null-- ��/��
   );
 
 
 
 
 
-- ����ջ���Ϣ��
create table  consumer_addr(
  
   id       int          primary key  auto_increment,
   name     varchar(20) not null, -- �ջ�������
   addr     varchar(200)  not null, -- �ջ��˵�ַ
   phone    varchar(20)   not null,  -- ��ϵ��ʽ
   provice  varchar(20)   , -- ʡ��
   city     varchar(20)   , -- ��
   area     varchar(40)   , -- ��/��
   message     varchar(200)  -- ��ϸ��Ϣ
   
);
 
 -- ������
 create table  orderinfo(
   
  id          int        primary key  auto_increment, -- ����id
  orderno     varchar(50)  not null,-- �������
  orderstatus  int        ,-- ����״̬     1:δ���� 2:�Ѹ��� 3:�ѷ��� 4:�����
  paystatus    int       ,-- 1:����֧��  2����������
  ordertime    bigint    ,-- �µ�ʱ��
  paytime      bigint    ,-- ����ʱ��
  addrinfo     int       ,-- �ջ�����Ϣ��������cosumer_addr���е�id
  mask         varchar(200) -- ��ע��Ϣ
 );
 
-- ��Զ��ϵ  ��������Ʒ
 create table  product_orderinfo(
   orderid     int     ,-- ����id ֵ������orderinfo���е�id
   productid   int     ,-- ��Ʒid,ֵ������product���е�id
   primary key(orderid,productid) -- ��������
 );