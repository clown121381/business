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

</head>
<body>
<script type="text/javascript">
var resource = new Resource();

$(document).ready(function(){
	resource.ctx='${ctx}';
	resource.formValidate();
});
		
</script>

	<form  name="addUpdateResouceForm" id="addUpdateResouceForm" autocomplete="off" >
   	<table border="0" >
   		<tr valign="top">
   			<td width="400" valign="top">
   				<div class="resourceItem" id="updateOpearHide">
		    		父资源名称:
		    		<input type="hidden" value="" name="resourcesParent" id="resourcesParent">
		    		<input type="hidden" value="" name="resourcesId" id="resourcesId">
		    		<span id="resourcesParentName"></span>
		    	</div>
		    	<div class="resourceItem">
		    		资源编码:
		    		<input type="text" name="resourcesCode" id="resourcesCode" maxlength="100" >
		    		<span id="resourcesCodeSpan"></span>
		    	</div>
		    	<div class="resourceItem">
		    		资源名称:
		    		<input type="text" name="resourcesName" id="resourcesName" maxlength="100"  >
		    	</div>
		    	<div class="resourceItem" >
		    		资源类型:
		    		<select name="resourcesType" id="resourcesType">
		    			<option value="M">菜单资源</option>
		    			<option value="F">功能资源</option>
		    		</select>
		    	</div>
		    	<div class="resourceItem">
		    		资源内容:
		    		<input type="text" name="resourcesLink" id="resourcesLink" maxlength="100" >
		    	</div>
		    	<div class="resourceItem">
		    		资源详情:
		    		<input type="text" name="resourcesNote" id="resourcesNote" maxlength="30">
		    	</div>
		    	<div class="resourceItem">
		    		资源排序:
		    		<input type="text" name="rank" id="rank" maxlength="50">
		    	</div>
		    	
   			</td>
   			
   		</tr>
   	</table>
   		<!-- 操作类型：删除、修改，不能删除该隐藏域 -->
   		<input type="hidden" value="" id="opeartype" name="opeartype">
   	</form>
</body>
</html>