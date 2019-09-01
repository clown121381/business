<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/resource/system-resource.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/lang/resource-lang.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/system-resourceTreeConvert.js"></script>


<style>
	.resourceItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
<script type="text/javascript">
var data = eval('('+'${resourceTree}'+')');


$(document).ready(function(){
	resource.createResourceTreeGrid(data);
	resource.ctx='${ctx}';
	resource.formValidate();
});

		
</script>
</head>

<table id="resourceList"   width="100%"></table>  

<!-- 弹出操作菜单项 -->
<div id="resource_menu" class="easyui-menu" style="width:110px;display: none" data-options="onClick:resource.selectMenu">   
    	<div data-options="iconCls:'icon-add',name:'addResourceMenu'" >添加资源</div>
    	<div data-options="iconCls:'icon-edit',name:'updateResourceMenu'">修改资源</div>
    	<div data-options="iconCls:'icon-remove',name:'delResourceMenu'">删除资源</div>  
    	<div data-options="iconCls:'icon-back',name:'moveResourceMenu'">移动资源</div>  
</div>

<!-- 弹出添加操作窗口 --> 
<div id="resource_addUpdate_window" style="font-size: 15px;padding: 10px;">   
   	
</div>
	