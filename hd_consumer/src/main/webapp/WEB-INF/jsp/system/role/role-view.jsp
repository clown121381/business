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

	<div style="padding-left: 20px;">
		<div class="roleItem" style="font-size: 12px;">
			角色名称: <span>${role.roleName }</span>
		</div>
		<div class="roleItem" style="font-size: 12px;">
			角色描述: <span>${role.note }</span>
		</div>
	</div>
	<div class="roleItem" align="center">
		<table class="easyui-datagrid" style="width: 380px; height: 250px;"
			data-options="fitColumns:true,singleSelect:true">
			<thead>
				<tr>
					<th data-options="field:'rolename',width:100">权限</th>
					<th data-options="field:'roledesc',width:100">描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${owerAuthoritys }" var="owerAuthority">
					<tr>
						<td>${owerAuthority.authorityName }</td>
						<td>${owerAuthority.note }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>