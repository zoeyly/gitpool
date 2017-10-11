function judge(){ 
	var _username = document.getElementById("username");
	var _errorSpan = document.getElementById("errorSpan"); 
	var _password = document.getElementById("password");
	if(_username.value == null || _username.value == ""){ 
		_errorSpan.innerHTML = "用户名不能为空"; return; 
	} 
	else{
		_errorSpan.innerHTML = "";
	} 
	if(_password.value == null || _password.value == ""){
	_errorSpan.innerHTML = "密码不能为空"; return; 
	}else{
	_errorSpan.innerHTML = "";  
	}
	loginForm.submit();
}
function zhuce(){
	self.location='zhuce.jsp'; 
}
