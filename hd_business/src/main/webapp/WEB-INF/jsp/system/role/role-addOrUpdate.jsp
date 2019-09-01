<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>

	<form name="addUpdateRoleForm" id="addUpdateRoleForm"
		autocomplete="off">
		<div>
			<fieldset>
				<legend>
					<strong>角色信息:</strong>
				</legend>
				<c:if test="${role.roleId != null }">
					<input type="hidden" value="${role.roleId }" name="roleId" id="roleId">
				</c:if>
				<div class="roleItem" style="font-size: 12px;">
					角色名称:
					<c:if test="${role.roleId != null }">
						<span>${role.roleName }</span>
					</c:if>
					<c:if test="${role.roleId == null }">
						<input type="text" value="${role.roleName }" name="roleName" id="roleName" maxlength="100">
					</c:if>
				</div>
				<div class="roleItem" style="font-size: 12px;">
					角色描述: 
					<input type="text" value="${role.note }"name="note" id="note" maxlength="100" data-rule="filter(<>^%&$*@#!);">
				</div>
			</fieldset>
		</div>
		<div class="roleItem">
			<fieldset>
				<legend>
					<strong>权限信息:</strong>
				</legend>
				<table border="0">
					<tr>
						<td><span style="font-size: 12px;">未拥有的权限</span></td>
						<td></td>
						<td><span style="font-size: 12px;">拥有的权限</span></td>
					</tr>
					<tr>
						<td width="160,50,160"><select multiple="multiple"
							style="width: 160px; height: 150px;" id="allAuthority">
								<c:forEach items="${authoritys }" var="authority">
									<option value="${authority.authorityId }">${authority.authorityName }</option>
								</c:forEach>
						</select></td>
						<td align="center">
							<div>
								<img alt="添加" onclick="role.addAuthority();"
									src="${ctx }/system/images/system-arrow-right.png"
									style="cursor: pointer; width: 20px;">
							</div>
							<div>
								<img alt="移除" onclick="role.removeAuthority();"
									src="${ctx }/system/images/system-arrow-left.png"
									style="cursor: pointer; width: 20px;">
							</div>
						</td>
						<td><select multiple="multiple" name="ownAuthority"
							style="width: 160px; height: 150px;" id="ownAuthority">
								<c:forEach items="${owerAuthoritys }" var="owerAuthority">
									<option value="${owerAuthority.authorityId }">${owerAuthority.authorityName }</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<input type="hidden" name="operate" id="operate" value="${operate }">
	</form>
	<!-- 为什么在这写js代码：因为easyui加载的时候如果js放到head上面，easyui是加载不到的，只加载body内容 -->
	<script type="text/javascript">
		var role = new Role();
		role.ctx = '${ctx}';
		$(document).ready(function() {
			role.formValidate();
		});
	</script>
</body>
</html>