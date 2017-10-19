<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% String username = request.getParameter("username"); %>

<!--
<body>
	欢迎<%=username %>登陆
</body>
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理--首页</title>
	<link rel="stylesheet" href="css/backstage.css" />
	<script type="text/javascript" src="js/backstage.js" ></script>
</head>

<body onload="onload()">
	<div class="backstage"> 
		<div class="top">
			<div class="name">
				后台管理				
			</div>
			<div class="middle">
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
		
		<div class="down">
				<div id="left"  style="background: url(img/bj.png); background-size: auto 100%;" >
				
				
			</div>
			
			
			<div class="right">
				<div class="right_top">
					<a>首页</a>
				</div>
				
				<div class="right_center">
					
					<ul> 
						<li>
							<a href="#">
								<div style="background: #438eb9;">
								<div id="centher_left">
									<img src="img/left-img1.png">
									<p>成交金额</p>
								</div>
								<div id="center_right" style="	background: #60a7d0;">
									4536.25元
								</div>
								</div>
							</a>
						</li>
						
						<li>
							<a href="#">
							<div style="background: #ff7171;">
								<div id="centher_left">
									<img src="img/left-img2.png">
									<p>订单</p>
								</div>
								<div id="center_right" style="background: #ff5757;">
									4589笔
								</div>
							</div>
							</a>
						</li>
						
						<li>
							<a href="#">
							<div style="background: #9cd159;">
								<div id="centher_left">
									<img src="img/left-img3.png">
									<p>通知</p>
								</div>
								<div id="center_right" style="background: #72b63f;">
									125条
								</div>
							</div>
							</a>
						</li>
						
						<li>
							<a href="#">
							<div style="background: #ff8e68;">
								<div id="centher_left">
									<img src="img/left-img4.png">
									<p>待处理</p>
								</div>
								<div id="center_right" style="background: #ff6633;">
									10条
								</div>
							</div>
							</a>
						</li>
						
						<li>
							<a href="#">
							<div style="background: #ad96d6;">
								<div id="centher_left">
									<img src="img/left-img5.png">
									<p>留言</p>
								</div>
								<div id="center_right" style="background: #8775a7;">
									48条
								</div>
							</div>
							</a>
						</li>
						
						<li>
							<a href="#">
							<div style="background: #fddf39;">
								<div id="centher_left">
									<img src="img/left-img6.png">
									<p>紧急通知</p>
								</div>
								<div id="center_right" style="background: #f5c23d;">
									2条
								</div>
							</div>
							</a>
						</li>
						
					</ul>
					
				</div>
				
				 <!--折线图-->
		       <div class=" panel">
		         <p>销售对比分析</p>
		         <img src="img/chart.png">
		        </div>
		       
		       
		       
		       <div id="right_down">
		       	 
		       	 <table id="node">
		           <tbody>
		           	<tr>
		           		<td colspan="2">
		           			<div class="-name">
					           <i></i>
					           	 <p id="p1">登录记录</p>
					           <a href="#">+更多</a>
					          </div>
		           		</td>
		           	</tr>
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		            
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		            
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		            
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		            
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		            
		            <tr>
		             <td>管理员</td>
		             <td>2017-05-26</td>
		            </tr>
		           </tbody>
		          </table>
				
				
			
					
					
			   <table id="shop">
		           <thead>
		           	<tr>
		           		<td colspan="2">
		           			<div class="-name">
					           <i></i>
					           	 <p id="p1">商品销售排行</p>
					           	<a href="#">+更多</a>
					          </div>
		           		</td>
		           	</tr>
		           
		            <tr>
		             <th width="50">排名</th>
		             <th>商品编号</th>
		             <th>商品名称</th>
		             <th width="80">销售数量</th>
		            </tr>
		           </thead>
		           <tbody>
		            <tr>
		             <td>
		              <em>1</em>
		             </td>
		             <td>2355456</td>
		             <td><a href="#">景观灯系列</a></td>
		             <td>26</td>
		            </tr>
		            
		             <tr>
		             <td>
		              <em>1</em>
		             </td>
		             <td>2355456</td>
		             <td><a href="#">景观灯系列</a></td>
		             <td>26</td>
		            </tr>
		            
		             <tr>
		             <td>
		              <em>1</em>
		             </td>
		             <td>2355456</td>
		             <td><a href="#">景观灯系列</a></td>
		             <td>26</td>
		            </tr>
		            
		             <tr>
		             <td>
		              <em>1</em>
		             </td>
		             <td>2355456</td>
		             <td><a href="#">景观灯系列</a></td>
		             <td>26</td>
		            </tr>
		            
		             <tr>
		             <td>
		              <em>1</em>
		             </td>
		             <td>2355456</td>
		             <td><a href="#">景观灯系列</a></td>
		             <td>26</td>
		            </tr>
		           </tbody>
		          </table>
				
		       </div>
		       
		       
			</div>
			</div>
			
			
		</div>
		
		
		
	</div>

</body>
</html>
