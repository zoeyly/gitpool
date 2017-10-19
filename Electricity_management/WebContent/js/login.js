function _curd(){
	var _oncl=document.getElementById("left_curd");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _shop(){
	var _oncl=document.getElementById("left_shop");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _rule(){
	var _oncl=document.getElementById("left_rule");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _orderinfo(){
	var _oncl=document.getElementById("left_orderinfo");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _address(){
	var _oncl=document.getElementById("left_address");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _account_consumer(){
	var _oncl=document.getElementById("left_account_consumer");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _account_product(){
	var _oncl=document.getElementById("left_account_product");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}
function _shoppinginfo(){
	var _oncl=document.getElementById("left_shoppinginfo");
	if(_oncl.style.display=="block"){
		_oncl.setAttribute("style","display: none;");
	}else{
		_oncl.setAttribute("style","display: block;");
	}
}



function topPage() {
	window.self.location = "page?pageNo=<%=pm.getTopPageNo()%>";
	
}

function previousPage() {
	window.self.location = "page?pageNo=<%=pm.getPreviousPageNo()%>";
}

function nextPage() {
	window.self.location = "page?pageNo=<%=pm.getNextPageNo()%>";
}

function bottomPage() {
	window.self.location = "page?pageNo=<%=pm.getBottonPageNo()%>";
}

function tijiao(){
	
}





function SelectAll() {
	 var checkboxs=document.getElementsByName("checkbox");
		 for (var i=0;i<checkboxs.length;i++) {
			  var e=checkboxs[i];
			  e.checked=!e.checked;
		 }
	}