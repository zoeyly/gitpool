<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link  type="text/css" rel="stylesheet"  href="css/style.css"/>
<link  type="text/css" rel="stylesheet"  href="css/index.css"/>
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
		</div>
   	</div>
	
	


  </div>
 </div>
 
 
 <div class="right-menu">
  <div class="main-hd">
   <div class="page-teb" style="height:887px;">
    <div class="l-tab-links">
     <ul style="left:0;">
      <li class="l-select">
       <a href="#" style="padding:0 25px;">首页</a>
      </li>
     </ul>
    </div>
    <div class="l-tab-content" style="height:851px;">
     <div class="tab-content-item">
      <div class="home">
      <!--成交金额-->
       <div class="space-style">
        <div class="col-xs">
         <a  href="#" class="title-button bg-deep">
          <div class="carousel">
           <div class="left-img">
            <i><img src="img/left-img1.png"></i>
            <p>成交金额</p>
           </div>
           <div class="right-info">4536.25元</div>
          </div>
         </a>
        </div>
        
         <div class="col-xs">
         <a  href="#" class="title-button bg-red">
          <div class="carousel">
           <div class="left-img bg-color-red">
            <i><img src="img/left-img2.png"></i>
            <p>订单</p>
           </div>
           <div class="right-info">4589笔</div>
          </div>
         </a>
        </div>
        
         <div class="col-xs">
         <a  href="#" class="title-button bg-green">
          <div class="carousel">
           <div class="left-img bg-color-green">
            <i><img src="img/left-img3.png"></i>
            <p>通知</p>
           </div>
           <div class="right-info">125条</div>
          </div>
         </a>
        </div>
        
         <div class="col-xs">
         <a  href="#" class="title-button bg-orange">
          <div class="carousel">
           <div class="left-img bg-color-orange">
            <i><img src="img/left-img4.png"></i>
            <p>待处理</p>
           </div>
           <div class="right-info">10条</div>
          </div>
         </a>
        </div>
        
         <div class="col-xs">
         <a  href="#" class="title-button bg-purple">
          <div class="carousel">
           <div class="left-img bg-color-purple">
            <i><img src="img/left-img5.png"></i>
            <p>留言</p>
           </div>
           <div class="right-info">48条</div>
          </div>
         </a>
        </div>
        
         <div class="col-xs">
         <a  href="#" class="title-button bg-yellow">
          <div class="carousel">
           <div class="left-img bg-color-yellow">
            <i><img src="img/left-img6.png"></i>
            <p>紧急通知</p>
           </div>
           <div class="right-info">2条</div>
          </div>
         </a>
        </div>
       </div>
       
       <!--折线图-->
       <div class="home-goods panel">
        <div class="home-mychart" style="height:400px;overflow:hidden;">
         <p>销售对比分析</p>
         <img src="img/chart.png">
        </div>
       </div>
       
       <!--销售情况-->
       <div class="order-form">
        <div class="col-xs-3 col-lg-7">
         <div class="admin-info">
          <div class="title-name">
           <i></i>
            登录记录
           <a href="#">+更多</a>
          </div>
          <table class="record-list">
           <tbody>
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
         </div>
        </div>
        
        <div class="col-xs-6 ranking-style">
         <div class="frame">
          <div class="title-name">
            <i></i>
            商品销售排行
           <a href="#">+更多</a>
          </div>
          <table class="table table-list">
           <thead>
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
    </div>
   </div>
  </div>
 </div>
</div>
</body>
</html>
