
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*,com.neusoft.entity.*,java.text.*" %> 
     
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
		<title>类别管理</title>
		<meta charset="utf-8" />

	</head>
	<body>
		<div id="_div">
			<div id="_button" >
				<div id="anniu">	
				 <a id="aa" href="AddFL.jsp"  >添加 </a>
			
				
				
				</div>
			</div>
			
			<div id="content_form" >
				<form method="get" action="">
					<table>
				
					<tr>
						<td>
						<input type="checkbox" name="all" id="zong" value="复选框"  onclick="SelectAll()"/> 全选
						</td>
						<td>cid</td>
						<td>cname</td>
						<td>pid</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<%
						 Object obj=request.getAttribute("cates");
						 if(obj!=null){// 
				        	  PageModel<Cate> pageModel=(PageModel<Cate>)obj;

				          
				              for(int i=0;i<pageModel.getDatas().size();i++){ 
				     %>
					<tr>
						<td>
						<input type="checkbox" name="checkbox" id="a" value="复选框" />
						</td>
						<td><%=pageModel.getDatas().get(i).getCid()%> </td>
						<td><%=pageModel.getDatas().get(i).getCname()%></td>
						<td><%=pageModel.getDatas().get(i).getPid()%></td>
						<td><a href="#">修改</a></td>
						<td>
							<a href="#">
							<form id="delete" action="deleteCateServlet" method="post">
								<input id="deletecate" type="button" value="删除" onclick="document.getElementById('delete').submit();">
							</form>
							</a>
						</td>
					</tr>
					<%
								}
				              
						%>
				</table>
					
				</form>
				
		   
            <div class="msg_page">
      		<div  style="text-align: center">
      	共<%=pageModel.getTotalcount() %>条记录 <%=pageModel.getPageNo() %>/<%=pageModel.getTotalPageSize() %>页
      	&nbsp;<a href="CateServlet?pageNo=1&pageSize=6">首页</a> 
      
      	<a href="CateServlet?&pageNo=<%=pageModel.getPageNo()-1==0? pageModel.getPageNo(): pageModel.getPageNo()-1%>&pageSize=5">上一页</a>&nbsp;
      
      	<a href="CateServlet?&pageNo=<%=pageModel.getPageNo()==pageModel.getTotalPageSize()? pageModel.getPageNo(): pageModel.getPageNo()+1%>&pageSize=5">下一页</a> 
      	
      	
      	<a href="CateServlet?pageNo=<%=pageModel.getTotalPageSize()%>&pageSize=5">尾页</a>
      	&nbsp;
      	第<select onChange="if(this.value==options[selectedIndex].value){location='CateServlet?&pageNo='+this.value+'&pageSize=5'}">
         
        
        <%
           if(pageModel!=null){
        	   int _totalPageSize=pageModel.getTotalPageSize(); 
        	   for(int i=0;i<_totalPageSize;i++){
        	     
        		    if(pageModel.getPageNo()==(i+1)){%>
        		    	
        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
        		  <%  }else{%>
        			  <option value="<%=i+1 %>" ><%=(i+1)%></option>
        		  <%}
        	   }
           }
        %>
       
       
        
        
      	</select>页
      		</div>
      	 </div>
       <!--留言列表End-->   
              
              
              
         <%
         	}
         %>
    
    	
			
		</div>
	</body>
	

<script>
	
	function ChkAllClick(sonName, cbAllId) {
				var arrSon = document.getElementsByName(sonName);
				var cbAll = document.getElementById(cbAllId);
				var tempState = cbAll.checked; //checked 属性规定在页面加载时应该被预先选定的 input 元素
				for(i = 0; i < arrSon.length; i++) {
					if(arrSon[i].checked != tempState)
						arrSon[i].click();//可模拟在按钮上的一次鼠标单击。
				}
		}
function change(obj){
	obj.style.color="#0000FF";
}

function change2(obj){
	obj.style.color="#000000";
}

function delte(){	
	var arrSon = document.getElementsByName("Son");
	
	for(var i=0;i<arrSon.length;i++){
	
		if(arrSon[i].checked == true){
			
			
			window.self.location = "DeleteCate?cid=" + arrSon[i].value;
		}
	}		
}


function update(){	
	var arrSon = document.getElementsByName("Son");
	
	for(var i=0;i<arrSon.length;i++){
	
		if(arrSon[i].checked == true){
			alert("确定要修改吗")
			/* alert(arrSon[i].value); */
			
			window.self.location = "updateCate.jsp?cid=" + arrSon[i].value;
		}
	}		
}




</script>
<style>
	
#_div{
}




#_button{
	margin-top: 20px;
	margin-bottom: 10px;

	
}
#anniu .T {
	border-radius:30px;
	outline: none;
	
	margin-left: 10px;
	
}

#content_form{
	background-color: #F5F5F5;
	margin-top: 20px;
}
#content_form table{
	margin: 0 auto;
	width: 900px;
	text-align: center;
}
#content_form table img{
	width: 40px;
	height: 40px;
}

#content_form th{
	width: 80px;
	height: 40px;
	font-size: 25px;
}
#content_form tr{
	font-size: 18px; 	
	width: 80px;
	height: 40px;
	border: 1px solid firebrick;
}
 span{
	cursor: pointer;
}
#aa{
	font-size: 25px;
}

</style>

</html>