<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色信息</title>
</head>
<body>
<script type="text/javascript">
$('#pg').propertygrid({
	columns: [[
	            { title: "用户信息", field: "name",width:30 },
	            { title: "", field: "value",width:80 }
	        ]],
    scrollbarSize: 0
});  
</script>
	<div id="tt" class="easyui-tabs" data-options="border:false,plain:true" style="width:378px;height:320px;">   
	    <div title="基本信息" style="" data-options="singleSelect:true"> 
			<input type="hidden" value="${userInfo.userId }" name="geUser.userid" id="userid">
			<table class="easyui-propertygrid" style="width:376px;height: 280px;" id="pg">
				<thead>   
			        <tr>   
			            <th data-options="field:'name',width:100">name</th>   
			            <th data-options="field:'value',width:100">名称</th>
		        	</tr>   
	    		</thead>
	    		<tbody>
				<tr>
					<td></td>
					<td>用户名</td>
					<td>${userInfo.userName }</td>
				</tr>
				<tr>
					<td></td>
					<td>电子邮箱</td>
					<td>${userInfo.email }</td>
				</tr>
				<tr>
					<td></td>
					<td>用户类型</td>
					<td>
						<c:if test="${userInfo.userType =='Y' }">
							超级管理员
						</c:if>
						<c:if test="${userInfo.userType !='Y' }">
							普通管理员
						</c:if>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>用户状态</td>
					<td>
						<c:if test="${userInfo.status =='Y' }">
							启用
						</c:if>
						<c:if test="${userInfo.status !='Y' }">
							冻结
						</c:if>
					</td>
				</tr>
				</tbody>
			</table>
	    </div>   
	    <div title="关联角色" style="">
			<table class="easyui-datagrid" style="width:376px;height: 280px;"   
		        data-options="fitColumns:true,singleSelect:true">   
			    <thead>   
			        <tr>   
			            <th data-options="field:'rolename',width:100">角色</th>   
			            <th data-options="field:'roledesc',width:100">描述</th>
			        </tr>   
			    </thead>  
			    <tbody>
					<c:forEach items="${owerRoles }" var="role">
				    	<tr>
				    		<td>${role.roleName }</td>
				    		<td>${role.note }</td>
				    	</tr>
					</c:forEach>
			    </tbody> 
			</table>   
	    </div>   
	</div>
</body>
</html>