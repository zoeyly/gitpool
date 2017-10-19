var title=[
	{"name":"库房管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"产品管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"订单管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"财务管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"库房管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"客户管理","number1":"入库单","number2":"出库单","number3":"库存"},
	{"name":"员工管理","number1":"入库单","number2":"出库单","number3":"库存"},
];

function onload(){
	var _left=document.getElementById("left");
		
	for(var i=0;i<title.length;i++){
		
		var  _div=document.createElement("div");
		//id
		_div.setAttribute("id","_div"+i);
		//css
		var _div_style="width:150px;height:80px;overflow: hidden;margin:0px auto;position:relative;left:-320px;";
		_div.setAttribute("style",_div_style);
	
//		onmouseover 鼠标经过
		_div.onmouseover=function(){
			
			
			var day = this.id+"name";
			var _day_p_onmouseover=document.getElementById(day);
			var _day_p_style="width:90%;height:80px;position:relative;background:;color:white;font-size:20px; text-align:center; line-height: 80px";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		};
		_div.onmouseout=function(){
			this.style.borderColor="gray";
			
			var id = this.id+"name";
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:90%;height:80px;position:relative;background: url(img/bj.png);color:white;font-size:15px; text-align:center; line-height: 80px";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		_left.appendChild(_div);
		
//		_div.onclick=function(){
//			alert(this.height);
////			alert(_div.overflow);
//	alert(_div.height);
//			if(_div.height == 80){
//			var day = this.id;
//			var _day_p_onmouseover=document.getElementById(day);
//			var _day_p_style="width:150px;height:80px;overflow: hidden;border:1px solid gray;margin:0px auto;position:relative;left:-320px; background-color:  red;";
//			_day_p_onmouseover.setAttribute("style",_day_p_style);
//			}else{
//				var day = this.id;
//				var _day_p_onmouseover=document.getElementById(day);
//				var _day_p_style="width:150px;height:80px;overflow:hidden ;border:1px solid gray;margin:0px auto;position:relative;left:-320px; background-color:  red;";
//				_day_p_onmouseover.setAttribute("style",_day_p_style);
//			}			
//		}
		
		
		
		var  _div_name=document.createElement("div");
		//id
		_div_name.setAttribute("id","_div"+i+"name");
		//css
		var _div_style="width:90%;height:80px;position:relative;background: url(img/bj.png);;color:white;font-size:15px; text-align:center; line-height: 80px ;";
		_div_name.setAttribute("style",_div_style);
		var _name_text=document.createTextNode(title[i].name);
		_div_name.setAttribute("onclick","change(this)");
		_div_name.appendChild(_name_text);
		_div.appendChild(_div_name);
		
		
//			
//		_div_name.onclick=function(){
//			var id = this.id+"number1";
//			var _day_p_onmouseover=document.getElementById(id);
//			var _day_p_style="width:100%;height:60px;position:relative;background:blue;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
//			_day_p_onmouseover.setAttribute("style",_day_p_style);
//		}
//		
//		
		var  _div_number1=document.createElement("div");
		//id
		_div_number1.setAttribute("id","_div"+i+"number1");
		//css
		var _div_style="width:100px;height:60px;position:relative;background: url(img/bj.png);;color:white;font-size:15px; padding-left:50px; line-height: 60px;margin-top:5px;";
		_div_number1.setAttribute("style",_div_style);
		var _number1_text=document.createTextNode(title[i].number1);
		_div_number1.appendChild(_number1_text);
		_div.appendChild(_div_number1);
		
		_div_number1.onmouseover=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background:;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		_div_number1.onmouseout=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background: url(img/bj.png);;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}


		var  _div_number2=document.createElement("div");
		//id
		_div_number2.setAttribute("id","_div"+i+"number2");
		//css
		var _div_style="width:100%;height:60px;position:relative;background: url(img/bj.png);;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
		_div_number2.setAttribute("style",_div_style);
		var _number2_text=document.createTextNode(title[i].number2);
		_div_number2.appendChild(_number2_text);
		_div.appendChild(_div_number2);
		
		_div_number2.onmouseover=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background:;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		_div_number2.onmouseout=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background: url(img/bj.png);color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		
		var  _div_number3=document.createElement("div");
		//id
		_div_number3.setAttribute("id","_div"+i+"number3");
		//css
		var _div_style="width:100%;height:60px;position:relative;background: url(img/bj.png);color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
		_div_number3.setAttribute("style",_div_style);
		var _number3_text=document.createTextNode(title[i].number3);
		_div_number3.appendChild(_number3_text);
		_div.appendChild(_div_number3);
		
		
		_div_number3.onmouseover=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background:;color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		_div_number3.onmouseout=function(){
			var id = this.id;
			var _day_p_onmouseover=document.getElementById(id);
			var _day_p_style="width:100%;height:60px;position:relative;background: url(img/bj.png);color:white;font-size:15px; text-align:center; line-height: 60px;margin-top:5px;";
			_day_p_onmouseover.setAttribute("style",_day_p_style);
		}
		
		
	}
	
	

}
function change(obj){
//	alert(obj.id);
//	alert(obj.id.substring(0,5));
	var a=obj.id.substring(0,5); 
	var div_oncl=document.getElementById(a);
	if(div_oncl.style.height=="80px"){
		div_oncl.setAttribute("style","width:150px;height:280px;overflow: hidden;border:1px solid gray;margin:0px auto;position:relative;left:-320px;");
	}else{
		 div_oncl.setAttribute("style","width:150px;height:80px;overflow: hidden;border:1px solid gray;margin:0px auto;position:relative;left:-320px; font-size:20px;");
	
	}
}
