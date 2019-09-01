<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>

</head>
<body>
	<script type="text/javascript" src="${ctx }/system/js/authority/system-authority.js"></script>
	<script type="text/javascript" src="${ctx }/system/js/resource/system-resourceTreeConvert.js"></script>
	<form  name="addUpdateAuthorityForm" id="addUpdateAuthorityForm" autocomplete="off" >
		
		<div style="width:400px;font-size: 12px;">
			<table border="0" width="100%" >
				<tr>
					<td valign="top">
						<c:if test="${operate != 'VIEW' }">
							<div style="width:400px;">
								<fieldset>
										<legend><strong>权限信息:</strong></legend>
									<div class="authorityItem" style="font-size: 12px">
										权限名称:
										<label>${authority.authorityName}</label>
									  	<input value="${authority.authorityName }"  <c:if test="${authority.authorityId != null }"> type="hidden" </c:if> 
									    <c:if test="${authority.authorityId == null }"> type="text"</c:if>  id="authorityName" maxlength="100" name="authorityName" >
									</div>
									<div class="authorityItem" style="font-size: 12px">
										权限描述:
									  	<input type="text" value="${authority.note }" id="note" maxlength="100" name="note" data-rule="filter(<>^%&$*@#!);">
									</div>
								</fieldset>
							</div>
						</c:if>
						<c:if test="${operate == 'VIEW' }">
							<div style="width:400px;">
								<fieldset>
										<legend><strong>权限信息:</strong></legend>
									<div class="authorityItem" style="font-size: 12px">
										权限名称:
										<label>${authority.authorityName}</label>
									</div>
									<div class="authorityItem" style="font-size: 12px">
										权限描述:
									  	<label>${authority.note }</label>
									</div>
								</fieldset>
							</div>
						</c:if>
						<div style="width:400px; height:200px;">
							<fieldset>
								<legend><strong>拥有的资源:</strong></legend>
								<div style="width:100%; height:200px; OVERFLOW-Y: auto; OVERFLOW-X:auto;border: 0px solid #ABADB3; text-align: left;">
									
									<ul style="text-align: left;" id="resourceTree"></ul>
									
								</div>
							</fieldset>
						</div>
						<input type="hidden" name="operate" id="operate" value="${operate }">
						<c:if test="${authority.authorityId != null }">
							<input type="hidden" value="${authority.authorityId}" id="authorityId" name="authorityId">
						</c:if>
						
					</td>
				</tr>
			</table>
	 	 </div>  
	</form>
	
		<script type="text/javascript">
		authority.ctx='${ctx}';
		$("document").ready(function(){
			authority.formValidate();
			var operate = $("#operate").val();
			var authorityId = $("#authorityId").val();
			var data = "operate="+operate+"&authorityId="+authorityId+"&date="+new Date();
			$.ajax({
				type:"POST",
				url:"${ctx}/sysAuthorit.do?method=getResourceTree",
				data:data,
				success:function(data){
					var d = JSON.parse(data);
					$('#resourceTree').tree({
						data: convert(d),
						animate:true,
						lines:true,
						checkbox:(operate != 'VIEW')
					});
				},
				error:function (XMLHttpRequest, textStatus, errorThrown){
					$.messager.alert('系统异常','系统异常,请稍后再试');
				}
			});
		});
	

	</script>
</body>
</html>