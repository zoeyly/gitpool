
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.neusoft.entity.*"%> 
<%@page import="com.neusoft.utils.*"%>
<%@page import="java.util.List"%>
<%@ page import="com.neusoft.controller.*"%> 
<%@page import="com.neusoft.dao.*"%>
<%@ page import="com.neusoft.daoimpl.*"%> 
<%@page import="com.neusoft.service.*"%>
<%@ page import="com.neusoft.Filert.*"%> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>库房分配</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
<link rel="stylesheet" href="css/find.css" />
<script type="text/javascript" src="js/login.js" ></script>
</head>

<body>

<div class="container">
 <div class="cont-top">
  <div class="companyname">后台管理</div>
  <div class="cont-top-middle">
   <ul>
    <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon.png">
      </div>
       <div class="top-txt">购物单</div>
     </a>
    </li>
    
    <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon1.png">
      </div>
      <div class="top-txt">收款单</div>
     </a>
    </li>
    
     <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon1.png">
      </div>
      <div class="top-txt">收款单</div>
     </a>
    </li>
    
     <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon1.png">
      </div>
      <div class="top-txt">收款单</div>
     </a>
    </li>
    
     <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon1.png">
      </div>
      <div class="top-txt">收款单</div>
     </a>
    </li>
    
     <li>
     <a href="#">
      <div class="top-middle">
       <img src="img/icon1.png">
      </div>
      <div class="top-txt">收款单</div>
     </a>
    </li>
   
   </ul>
  </div>
  
 </div>
 <div class="left-menu" style="height:949px;">
  <div class="menu-list">
  	<!-- 类别-->
   	<div >
   		<div id="_curd" onclick="_curd()">
			类别
		</div>
		<div id="left_curd">
			<a href="addCate.jsp">
			<div id="add" >
				添加类别
			</div>
			</a>
			<a href="deleteCate.jsp">
			<div id="delect" >
				删除类别
			</div>
			</a>
			<a href="changeCate.jsp">
			<div id="change" >
				修改类别
			</div>
			</a>
			<a href="findCate.jsp">
			<div id="find">
				查询类别
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/findCatesServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>
   	<div>
   		<div id="_curd" onclick="_shop()">
			商品
		</div>
		<div id="left_shop">
			<a href="addShop.jsp">
			<div id="add" >
				添加商品
			</div>
			</a>
			<a href="deleteShopp.jsp">
			<div id="delect" >
				删除商品
			</div>
			</a>
			<a href="changeShop.jsp">
			<div id="change" >
				修改商品
			</div>
			</a>
			<a href="findShop.jsp">
			<div id="find">
				查询商品
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listPorductServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
			
		</div>
   	</div>
	<div>
   		<div id="_curd" onclick="_rule()">
			规格
		</div>
		<div id="left_rule">
			<a href="addRule.jsp">
			<div id="add" >
				添加规格
			</div>
			</a>
			<a href="deleteRule.jsp">
			<div id="delect" >
				删除规格
			</div>
			</a>
			<a href="changeRule.jsp">
			<div id="change" >
				修改规格
			</div>
			</a>
			<a href="findRule.jsp">
			<div id="find">
				查询规格
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listRuleServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>		
	<div>
   		<div id="orderinfo" onclick="_orderinfo()">
			订单
		</div>
		<div id="left_orderinfo">
			<a href="addOrderinfo.jsp">
			<div id="add" >
				添加订单
			</div>
			</a>
			<a href="deleteOrderinfo.jsp">
			<div id="delect" >
				删除订单
			</div>
			</a>
			<a href="changeOrderinfo.jsp">
			<div id="change" >
				修改订单
			</div>
			</a>
			<a href="findOrderinfo.jsp">
			<div id="find">
				查询订单
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listOrderinfoServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>		
		<div>
   		<div id="_curd" onclick="_address()">
			地址
		</div>
		<div id="left_address">
			<a href="addAddress.jsp">
			<div id="add" >
				添加地址
			</div>
			</a>
			<a href="deleteAddress.jsp">
			<div id="delect" >
				删除地址
			</div>
			</a>
			<a href="changeAddress.jsp">
			<div id="change" >
				修改地址
			</div>
			</a>
			<a href="findAddress.jsp">
			<div id="find">
				查询地址
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listAddressServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>		
				<div>
   		<div id="_curd" onclick="_account_product()">
			卖家
		</div>
		<div id="left_account_product">
			<a href="addProduct.jsp">
			<div id="add" >
				添加卖家
			</div>
			</a>
			<a href="deleteProduct.jsp">
			<div id="delect" >
				删除卖家
			</div>
			</a>
			<a href="changeProduct.jsp">
			<div id="change" >
				修改卖家
			</div>
			</a>
			<a href="findProduct.jsp">
			<div id="find">
				查询卖家
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listACCProductServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>		
				<div>
   		<div id="_curd" onclick="_account_consumer()">
			买家
		</div>
		<div id="left_account_consumer">
			<a href="addConsumer.jsp">
			<div id="add" >
				添加买家
			</div>
			</a>
			<a href="deleteConsumer.jsp">
			<div id="delect" >
				删除买家
			</div>
			</a>
			<a href="changeConsumer.jsp">
			<div id="change" >
				修改买家
			</div>
			</a>
			<a href="findConsumer.jsp">
			<div id="find">
				查询买家
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listConsumerServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>
  	  	<div >
   		<div id="_shoppinginfo" onclick="_shoppinginfo()">
			购物车
		</div>
		<div id="left_shoppinginfo">
			<a href="addShoppinginfo.jsp">
			<div id="add" >
				添加购物车
			</div>
			</a>
			<a href="deleteShoppinginfo.jsp">
			<div id="delect" >
				删除购物车
			</div>
			</a>
			<a href="changeShoppinginfo.jsp">
			<div id="change" >
				修改购物车
			</div>
			</a>
			<a href="findShoppinginfo.jsp">
			<div id="find">
				查询购物车
			</div>
			</a>
			<a href="http://localhost:8080/Electricity_management/listShopinfoServlet?pageSize=5&pageNo=1">
			<div id="list">
				查询分页
			</div>
			</a>
		</div>
   	</div>
	
	


  </div>
 </div>
 
 <div class="right-menu">
  <div class="main-hd">
   <div class="page-teb" >
    <div class="l-tab-links">
     <ul style="left:0;">
      <li class="l-select">
       <a href="#" style="padding:0px 25px;">首页</a>
      </li>
       <li class="l-select">
       <a href="#">库房分配</a>
       <span class="close"></span>
      </li>
     </ul>
    </div>
    
<div class="meassage" style=" width: 100%; height: 100%;     position: absolute;
    top: 50px;left:0px;background: white;">
    	
    
		<div class="all" >
		<%
			Account_productService mbs = new Account_productService();
			List<Account_product> list=mbs.showproductAll();
			request.setAttribute("all", list);
		%>
			
		<table class="table" style="width: 400px" border="1" cellspacing="1" cellpadding="1">
			<tr>
				<td>
				<input type="checkbox" name="all" id="zong" value="复选框"  onclick="SelectAll()"/>全选</br>
				</td>
				<td>id</td>
				<td>loginname</td>
				<td>password</td>
				<td>registertime</td>
				<td>lastlogintime</td>
				<td>ip</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
			<%
    			for(int i=0; i<list.size(); i++){
    				Account_product mb=list.get(i);
    	%>
 			<tr >
 				<td>
 				<input type="checkbox" name="checkbox" id="a" value="复选框" />
 				</td>
				<td><%=mb.getId() %></td>
				<td><%=mb.getLoginname() %></td>
				<td><%=mb.getPassword()%></td>
				<td><%=mb.getRegistertime()%></td>
				<td><%=mb.getLastlogintime()%></td>
				<td><%=mb.getIp()%></td>
				<td><a>修改</a></td>
				<td>
					<form id="delete" action="deleteShopServlet" method="post">
						<input id="deleteshop" type="button" value="删除" onclick="document.getElementById('delete').submit();">
					</form>
				</td>
			</tr>
		
    			
		 <% 		
		 		}
    	%>
		
				</table>
				</div>
				
		
	
		
		
		
		
		
				
</div>
   
      </div>      
     </div>
    </div>
   </div>
  
</body>
</html>
