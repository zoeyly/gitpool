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

</head>
<link rel="stylesheet" href="css/find.css" />
<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
<script src="js/Area.js" type="text/javascript"></script>
<script src="js/AreaData_min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/address.js" ></script>

<body> 
	<div id="name">
		　　用户信息
	</div>
		<div>
			用户名： ${user.loginname}
		</div>
	<div  id="name">
		　　订单状况
	</div>
		
		
		<%
			OrderinfoService bs = new OrderinfoService();
			List<Orderinfo> ist=bs.showOrderinfoAll();
			ist.get(ist.size()-1); 
		%>
		<div>
			订单id：<%=ist.get(ist.size()-1).getId() %>
		</div>	
		<div>
			用户id：<%=ist.get(ist.size()-1).getAddrinfo() %>
		</div>
		<div>
			商品总件数：<%=ist.get(ist.size()-1).getMask() %>
		</div>
		<%  double money=0;%>
		<%
			ShoppinginfoService mbs = new ShoppinginfoService();
			List<Shoppinginfo> list=mbs.showShoppinginfoAll();
			for(int i=0; i<list.size(); i++){
				Shoppinginfo mb=list.get(i);
				money+=mb.getMoney();
			}
		%>
		<div>
			商品总价格：<%=money %>
		</div>

	<div  id="name">
		　　收货地址
	</div>
	<div>
		<form id="insert" action="loginAddressServlet" method="post">
				 <table  width="70%" border="1" cellspacing="1" cellpadding="1">
					<tr>
					    <td >
				   			省:
				   		</td>
				   		<td>
				   		   <select id="province" name="province" onChange="changeComplexProvince(this.value, sub_array, 'city', 'county');"></select>
				   		</td>
					</tr>
					<tr>
					    <td>
					    	市:
					    </td>
					    <td>
					    	<select id="city" name="city" onChange="changeCity(this.value,'county','county');"></select>
					    </td>
					</tr>
					<tr>
					    <td>
					    	县:
					    </td>
					    <td>
					   		<select id="county" name="county"></select>
					    </td>
					</tr>
						  </table>
				
				<input id="add" type="button" value="提交" onclick="document.getElementById('insert').submit();">
					</form>
	</div>
	


</body>
</html>
