<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.authorityItem{
	padding-top: 10px;
}
.n-invalid {border: 1px solid red;}
</style>
<head>
<script type="text/javascript" src="${ctx }/system/js/authority/system-authority.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ESC后台管理</title>
</head>
<script type="text/javascript">
//创建表格
	$(document).ready(function(){
		authority.createAuthorityGrid();
	});
	authority.ctx='${ctx}';

</script>
<body>
<table id="authorityData"  width="100%"></table>
<div id="searchBar" style="margin :0px; padding :5px;padding-right: 10px;width: 100%; display: none;">
	<div>
		<div style="float: left;padding: 5px;font-size: 12px;">权限名称：<input type="text" id="authorityNameSearch"  onkeydown='if(event.keyCode==13) authority.searchAuthorityData()'/></div>
		<div style="float: left;padding: 5px;width: 80px;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick=authority.searchAuthorityData() >查询</a></div>
	</div>
</div>

<div id="authorityData_add_window" style="background-color:white ;font-size: 15px;padding: 10px;"></div>

</body>
</html>