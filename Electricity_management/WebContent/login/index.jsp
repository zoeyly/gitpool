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
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>页面登录</title>

<script src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/login.js" ></script>
<link rel="stylesheet" href="css/login.css" />
</head>

<body>
<div class="form">
	<div id="landing">登陆</div>
	<div id="registered">注册</div>
	<div class="fix"></div>
	<div id="landing-content">
		<form id="login" action="http://localhost:8080/Electricity_management/newLoginServlet" method="post">
		<div id="photo"><img src="img/photo.jpg"></div>
		<div class="inp">
			<input id="loginname" name="loginname" type="text" placeholder="用户名">
		</div>
		<div class="inp">
			<input id="password" name="password" type="password" placeholder="密码">
		</div>
		<div class="login"  onclick="document.getElementById('login').submit()">登录</div>
		<div id="bottom"><span id="registeredtxt">立即注册</span><span id="forgotpassword">忘记密码</span></div>
		</form>
	</div>
	<div id="registered-content">
		<from>
		<div class="inp">
			<input id="loginname" name="loginname" type="text" placeholder="请输入用户名">
		</div>
		<div class="inp">
			<input id="password" name="password" type="password" placeholder="请输入密码">
		</div>
		<div class="inp"><input type="password" placeholder="请再次输入密码"></div>
		<div class="inp"><input type="text" placeholder="手机号码"></div>
		<div class="login">立即注册</div>
	</div>
	</from>
</div>

</html>
