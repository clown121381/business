<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script type="text/javascript" src="${ctx }/system/js/organ/organTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/userManage/userGrid.js"></script>
</head>
<body>
	<form name="userManageForm" id="userManageForm"  data-validator-option="{theme: 'yellow_right',timely:1}">
		<input type="hidden" name="operate" id="operate" value="${operate }">
		<input type="hidden" name="operatorname" id="operatorname" value="${userInfo.userName }">
		<c:if test="${userInfo.userId != null }">
			<input type="hidden" value="${userInfo.userId }" name="userId" id="userId">
		</c:if>
		<div id="user_operate" class="easyui-tabs" data-options="border:false,plain:true" style="width:420px;height:320px;"> 
			<div title="基本信息" style="overflow:hidden;" data-options="singleSelect:true"> 
			<table style="margin-top: 10px;font-size: 12px">
				<tr>
					<td class="tabLeft">用户名：</td>
					<td>
						<c:if test="${userInfo.userId != null }">
							${userInfo.userName }
							<input type="hidden" value="${userInfo.userName }" id="userName" name="userName">
							<span style="margin-left:20px;color:red;cursor: pointer;" onclick="canclerepwd();" id="canclerepwd">取消修改密码</span>
						</c:if>
						<c:if test="${userInfo.userId == null }">
							<input type="text" id="userName" name="userName" onkeyup="this.value =this.value.replace(/[^a-zA-Z0-9_\u4e00-\u9fa5]/g, '')">
						</c:if>
					</td>
				</tr>
				<tr id="repwdbtn" style="display: none;">
					<td class="tabLeft">密 码：</td>
					<td><span style="color:red;cursor: pointer;" onclick="repwdclick();" id="repwdbtn">修改密码</span></td>
				</tr>
				<tr id="pwdinput">
					<td class="tabLeft">密 码：</td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr id="againpwdinput">
					<td class="tabLeft">确认密码：</td>
					<td><input type="password" id="againpwd" name="againpwd"></td>
				</tr>
				<tr>
					<td class="tabLeft">电子邮箱：</td>
					<td><input type="text" value="${userInfo.email }" id="email" name="email"></td>
				</tr>
				<tr>
					<td class="tabLeft">用户类型：</td>
					<td>
					<select id ="userType" name="userType" >
						<c:if test="${userInfo.userType =='Y' }">
							<option value="N">普通管理员</option>
							<option value="Y" selected="selected">超级管理员</option>
						</c:if>
						<c:if test="${userInfo.userType !='Y' }">
							<option value="N" selected="selected">普通管理员</option>
							<option value="Y" >超级管理员</option>
						</c:if>
					</select>
					</td>
				</tr>
				<tr>
					<td class="tabLeft">用户状态：</td>
					<td>
					<select id ="status" name="status" >
						<c:if test="${userInfo.status !='N' }">
							<option value="Y" selected="selected">启用</option>
							<option value="N">冻结</option>
						</c:if>
						<c:if test="${userInfo.status =='N' }">
							<option value="Y" >启用</option>
							<option value="N" selected="selected">冻结</option>
						</c:if>
						
					</select>
					</td>
				</tr>
			</table>
			</div>
			<div title="关联角色" style="">
				<table border="0">
					<tr>
						<td><span style="font-size: 12px">未分配的角色</span></td>
						<td></td>
						<td><span style="font-size: 12px">已拥有角色</span></td>
					</tr>
					<tr>
						<td width="160,50,160">
							<select multiple="multiple" style="width: 195px; height: 265px;" id="allRoles">
								<c:forEach items="${roles }" var="role">
									<option value="${role.roleId }">${role.roleName }</option>
								</c:forEach>
							</select>
						</td>
						<td align="center">
							<div><img alt="添加" onclick="userManage.addRole();" src="${ctx }/system/images/system-arrow-right.png" style="cursor: pointer;width: 20px;"></div>
							<div><img alt="移除" onclick="userManage.removeRole();" src="${ctx }/system/images/system-arrow-left.png" style="cursor: pointer;width: 20px;"></div>
						</td>
						<td>
							<select multiple="multiple" name="geUsergroup.usergroupid"  style="width: 190px; height: 265px;" id="owerRoles">
								<c:forEach items="${owerRoles }" var="owerRole">
									<option value="${owerRole.roleId }">${owerRole.roleName }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			userManage.formValidate();
			if($('#operate').val() == 'UPDATE'){
				userManage.opPwdInput('hide');
			}
		});
		
		function repwdclick() {
			userManage.opPwdInput();
		}
		function canclerepwd() {
			userManage.opPwdInput('hide');
		}
	</script>
</body>
</html>