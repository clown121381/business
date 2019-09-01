<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/system/js/role/system-role.js"></script>
<title>角色管理</title>
<script type="text/javascript">
	var role = new Role();
	role.ctx = '${ctx}';
	$(document).ready(function() {
		role.createRoleTreeGrid();
		role.formValidate();
	});
	/**
	 *查询资源
	 */
	function searchRoles() {
		role.searchData($("#rolename-search").val());
	}
</script>
<style type="text/css">
.roleItem {
	padding-top: 10px;
}

.n-invalid {
	border: 1px solid red;
}
</style>
</head>
<body>



	<!-- 权限（数据）表格 -->
	<table id="roleDatagrid" width="100%"></table>



	<!-- 新添加查询工具栏目 -->
	<div id="searchBar"
		style="margin: 0px; padding: 5px; padding-right: 10px; width: 100%; display: none;">
		<div>
			<div style="float: left; padding: 5px; font-size: 12px;">
				角色名称：<input type="text" id="rolename-search" name="dicttypeid">
			</div>
			<div style="float: left; padding: 5px; width: 80px;">
				<a id="search" onclick="searchRoles();" href="#"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			</div>
		</div>
	</div>

	<!-- 弹出添加操作窗口 -->
	<div id="role_addUpdate_window"
		style="background-color: white; font-size: 15px; padding: 10px;">
	</div>
</body>
</html>