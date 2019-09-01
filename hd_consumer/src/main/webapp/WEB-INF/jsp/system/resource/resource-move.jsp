<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECS后台管理</title>
<script type="text/javascript" src="${ctx }/system/js/resource/resourceTreeConvert.js"></script>
<script type="text/javascript" src="${ctx }/system/js/resource/resource.js"></script>
<style>
	.resourceItem{
		padding-top: 10px;
	}
	.n-invalid {border: 1px solid red;}
</style>
<script type="text/javascript">
var resource = new Resource();

$(document).ready(function(){
	resource.ctx='${ctx}';
});
		
</script>

</head>
<body>
<div style="width:100%; OVERFLOW-Y: auto; OVERFLOW-X:auto;border: 0px solid #ABADB3; text-align: left;">
<ul style="text-align: left;" id="resourceMoveList" ></ul>  
</div>

</body>
</html>