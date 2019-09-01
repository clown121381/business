var SystemLogin = function(){};
SystemLogin.prototype.ctx = null;

/**
 * 用户点击登录按钮事件处理
 */
SystemLogin.prototype.login = function(){

	var username = $("#username").val().replace(/\s+/g,"");
	var password = $("#password").val().replace(/\s+/g,"");
	var authCode = $("#authCode").val().replace(/\s+/g,"");
	if(username == ""){
		$(".login-error-tip").html("* 请输入用户名");
		$("#username").focus();
		return false;
	}
	if(password == ""){
		$(".login-error-tip").html("* 请输入密码");
		$("#password").focus();
		return false;
	}
	if(authCode == ""){
		$(".login-error-tip").html("* 请输入验证码");
		$("#authCode").focus();
		return false;
	}
	else{
		data = "&username="+username+"&password="+password+"&authCode="+authCode
		$.ajax({
			type : "POST",
			url : this.ctx+"/userLogin.do?method=checkLogin",
			data : data,
			success : function(data) {
				if("true" == data){
				    	document.loginForm.submit();
				}else{
					$(".login-error-tip").html("* "+data);
				}

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.messager.alert('系统异常', '系统异常,请稍后再试');
			}
		});

		
		
		
		
	}
};

var systemLogin = new SystemLogin();