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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   
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
	<li>喵，欢迎来天猫</li>
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
		<a href="loginCate?cid=<%=list.get(i).getCid() %>">
			<%=mb.getCname()%>
		</a>
	</div>
	
 <% 		
		 		}
    	%>
	

</div>

<div id="right">
<c:forEach items="${flag }" var="pro" >
	<form id="jvForm" action="loginShopServlet?aid=${user.id}&nickname=${user.loginname}&price=${pro.getPrice()}" method="post">
		
	
	
	<table class="table"  width="200" border="1" cellspacing="1" cellpadding="1">
   
	  <tr>
	    <td colspan="2" align="center" valign="middle">${pro.id}</td>
	  </tr>
	  <tr>
	    <td align="center" valign="middle" >${pro.pname}</td>
	    <td align="center" valign="middle" >${pro.cid}</td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center" valign="middle"><img src="img/${pro.pic}.jpg" /></td>
	  </tr>
	  <tr>
	    <td align="center" valign="middle">${pro.pdetail}</td>
	    <td align="center" valign="middle">
	    	<button onclick="addShoppinginfoServlet" value="加入购物车">加入购物车</button>
	    </td>
	  </tr>
	  
	</table>
	

	
	</form>	
		</c:forEach>
<!-- 
		
<table width="200" border="1" cellspacing="1" cellpadding="1">
  <tr>
    <td colspan="2" align="center" valign="middle">商品编号</td>
  </tr>
  <tr>
    <td align="center" valign="middle" >商品名称</td>
    <td align="center" valign="middle" >商品类别</td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle">商品图片</td>
  </tr>
  <tr>
    <td align="center" valign="middle">商品详情</td>
    <td align="center" valign="middle">加入购物车</td>
  </tr>
</table>
		-->

</div>

</body>
</html>
