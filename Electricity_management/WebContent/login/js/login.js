$(document).ready(function() {
		
		$(".form").slideDown(500);
		
		$("#landing").addClass("border-btn");

		$("#registered").click(function() {
			$("#landing").removeClass("border-btn");
			$("#landing-content").hide(500);
			$(this).addClass("border-btn");
			$("#registered-content").show(500);
			
		})

		$("#landing").click(function() {
			$("#registered").removeClass("border-btn");
			$(this).addClass("border-btn");
			
			$("#landing-content").show(500);
			$("#registered-content").hide(500);
		})
	});

function login(){ 
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