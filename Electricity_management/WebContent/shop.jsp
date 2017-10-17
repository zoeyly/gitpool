<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.neusoft.entity.*"%> 
<%@page import="com.neusoft.utils.*"%>
<%@page import="java.util.List"%>
<%@ page import="com.neusoft.controller.*"%> 
<%@page import="com.neusoft.dao.*"%>
<%@ page import="com.neusoft.daoimpl.*"%> 
<%@page import="com.neusoft.service.*"%>
<%@ page import="com.neusoft.Filert.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>前台 -  用户界面</title>
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/login.js" ></script>
</head>

<body> 
<div id="top">
<ul>
	<li><a href="http://localhost:8080/Electricity_management/index.jsp">用户：${user.loginname}</a></li>
    <li><a href="http://localhost:8080/Electricity_management/zhuce.jsp">免费注册</a></li>
    <li><a href="#">我的淘宝</a></li>
    <li><a href="#">淘宝网</a></li>
    <li><a href="#">商家支持</a></li>
    <li><a href="#">网站导航</a></li>
    <li><img src="img/u=3655165999,725079547&fm=27&gp=0.jpg"/>
    	<a href="shop.jsp">购物车</a>
    </li>
</ul>
</div>

<div id="left">
	
	<div>
		<h1>商品类别</h1>
	</div>
		<%
		CateService mbs = new CateService();
			List<Cate> list=mbs.showCateAll();
			request.setAttribute("all", list);
	%>
	<%
    			for(int i=0; i<list.size(); i++){
    				Cate mb=list.get(i);
    	%>
	<div id="message">
		<a href="cate<%=list.get(i).getCid() %>.jsp">
			<%=mb.getCname()%>
		</a>
	</div>
	 <% 		
		 		}
    	%>
	

</div>

<div id="right">
	
	<div  id="button" >
		<a href="from.jsp">
			<button value="确认购买">确认购买</button>
		</a>
	</div>

	<table class="table"  style="width: 70%" border="1" cellspacing="1" cellpadding="1">
		<tr>
			<td>
				<input type="checkbox" name="all" id="zong" value="复选框"  onclick="SelectAll()"/>全选</br>
			</td>
			<td>用户ID</td>
			<td>用户名</td>
			<td>商品名</td>
			<td>商品价格</td>
			
		</tr>
		
		<%
		ShoppinginfoService consumerService = new ShoppinginfoService();
		List<Shoppinginfo> consumers=consumerService.showShoppinginfoAll();
		request.setAttribute("all", consumers);
			for(int i=0; i<consumers.size(); i++){
				Shoppinginfo account=consumers.get(i);
		%>
		
		<tr>
			<td>
 				<input type="checkbox" name="checkbox" id="a" value="复选框" />
 			</td>
			<td>${user.id}</td>
			<td>${user.loginname}</td>
			<td><%=account.getNickname() %></td>
			<td><%=account.getMoney() %></td>
		</tr>
		
		<%} %>
	</table>


</div>

</body>
</html>
