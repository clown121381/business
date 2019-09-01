<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>ECS后台管理</title>
		<link rel="stylesheet" type="text/css" href="${ctx }/system/css/system-login.css">
		<script type="text/javascript"  src="${ctx }/common/js/easyui/jquery.min.js"></script>
		<script type="text/javascript"  src="${ctx }/system/js/system-login.js"></script>
	</head>

	<script type="text/javascript">
	systemLogin.ctx = '${ctx}';

	</script>
	<body>
		<form action="${ctx }/userLogin.do?method=doMain" name="loginForm" method="post">
			<!--顶部-->
			<div class="system-login-top">    
				<span>欢迎登录管理后台</span>    
			</div>
			<!--中部-->
			<div class="system-login-center">
				    <div class="system-login">
						<table width="100%">
							<tr>
								<td width="300,*">
									&nbsp;
								<td>
								<td>
									<div class="login-element login-error-tip">
									</div>
									<div class="login-element">
										<input name="username" id="username" type="text" class="login-user" value="" maxlength="20"/>
									</div>
									<div class="login-element">
										<input name="password" id="password" type="password" class="login-password" value="" maxlength="20"/>
									</div>
									<div class="login-element">
										<table width="100%">
											<tr>
												<td width="100,*" align="left">
													<input name="authCode" id="authCode" type="text" value="" class="login-authcode" maxlength="4"/>
												</td>
												<td align="left">
													<img alt="" src="${ctx }/userLogin.do?method=getAuthCode&date=1" onclick="$(this).attr('src','${ctx }/userLogin.do?method=getAuthCode&date='+new Date())" style="width: 90px;cursor: pointer;height: 28px;line-height:28px;" />
												</td>
											</tr>
										</table>
									</div>
									<div class="login-element">
										<input name="" type="button" class="login-button" value="登录"  onclick="systemLogin.login();"  />
									</div>
									
								<td>
							</tr>
						</table>
				    </div>
			 </div>
		 </form> 
		    
		    
		  <div class="system-login-bottom"></div>
	</body>
</html>