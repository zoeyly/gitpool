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
	<table>
		<tr>
			<td>用户ID</td>
			<td>用户名</td>
			<td>商品名</td>
			<td>商品价格</td>
			
		</tr>
		
		<%
		ProductService consumerService = new ProductService();
		List<Product> consumers=consumerService.showProductAll();
		request.setAttribute("all", consumers);
			for(int i=0; i<consumers.size(); i++){
				Product account=consumers.get(i);
		%>
		
		<tr>
			<td>${user.id}</td>
			<td>${user.loginname}</td>
			<td><%=account.getPname()%></td>
			<td><%=account.getPrice() %></td>
		</tr>
		
		<%} %>
	</table>


</div>

</body>
</html>
