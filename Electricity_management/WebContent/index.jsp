<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>前台</title>
		<link rel="stylesheet" href="css/new.css" />
		<script type="text/javascript" src="js/index.js" ></script>
	</head>
	<body>
		<div class="top">
			
		</div>
		<div class="down">
			<form name="loginForm" action="ckeditorServlet" method="post">
				<input type="hidden"  name="type"  value="1"/>
				<div style="width: 350px;height: 350px;position: absolute;top:5%;left:55%;border: 2 solid black; background:powderblue ;">
					<div style="height: 20%; font-size: 25px;text-align: center;line-height: 60px;background: turquoise; color: darkolivegreen;">
					系统登录
				</div>
				<div style="height: 20%; font-size: 20px;padding-left: 15%;color: white;margin-top: 15px;">
					用户名：
					<br />
					<input id="username" name="username" style="border: 1px solid silver; border-radius: 5px;background-color: ;width: 200px;height: 25px;" placeholder="请输入用户名" /><br />
					<div style="height: 20%; font-size: 20px;color: white;margin-top: 10px;">
						密码：<br />
						<input id="password" name="password" style="border: 1px solid silver; border-radius: 5px;background-color: ;width: 200px;height: 25px;margin-top: 7px;" placeholder="请输入密码" /><br />
						<input id="checkbox" type="checkbox"  name="checkbox"   value="1" style="margin-top: 20px;margin-left:30%; "/>
						：记住密码！</br>
					</div>
					<div>
						<span id="errorSpan" style="color: red;"></span><br />
						<input type="button" onclick="judge()" style="border: 1px solid silver;width: 100px;height: 30px;margin-top: 90px;margin-left: 5%;background-color: ;text-align: center;"value="登录"></input>
						<input type="button" onclick="zhuce()" style="border: 1px solid silver;width: 100px;height: 30px;position: absolute;top:282px;left:50%;background-color: ;text-align: center;"value="注册"></input>
					</div>
			</form>
			
		</div>
	</body>
</html>
