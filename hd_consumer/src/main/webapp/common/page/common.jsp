<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL标签 -->
<%@ taglib prefix="c" uri="core" %>
<%@ taglib prefix="fmt" uri="fmt" %>
<%@ taglib prefix="fn" uri="fn" %>


<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>


<%
	String[] browserLanguages = request.getHeader("Accept-Language").split(",");
%>


<c:set var="browserLanguage" value="<%=browserLanguages[0].toLowerCase()%>"></c:set>
<!--  -->
<link rel="stylesheet" type="text/css" href="${ctx }/common/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx }/common/css/niceValidate/jquery.validator.css">
<link rel="stylesheet" type="text/css" href="${ctx }/common/js/easyui/themes/default/easyui.css">



<script type="text/javascript" src="${ctx }/common/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/common/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/common/js/easyui/locale/easyui-lang-${browserLanguage }.js"></script>
<script type="text/javascript" src="${ctx }/common/js/easyui/easyui-extend.js"></script>

<!-- 系统默认提供的语言包 -->
<script type="text/javascript" src="${ctx }/common/js/iecs/lang/ecs-lang.js"></script>
<script type="text/javascript" src="${ctx }/common/js/niceValidate/jquery.validator.js"></script>
<script type="text/javascript" src="${ctx }/common/js/niceValidate/zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/common/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx }/common/js/iecs/ECSHint.js"></script>


<script type="text/javascript">
$(document).ajaxComplete(function(event, xhr, settings) {  
    if(xhr.getResponseHeader("sessionstatus")=="timeOut"){  
        if(xhr.getResponseHeader("loginPath")){
            alert("会话过期，请重新登陆!");
			window.top.location.href=xhr.getResponseHeader("loginPath");
//          window.location.replace(xhr.getResponseHeader("loginPath"));  
        }else{
            alert("请求超时请重新登陆 !");  
        }  
    }  
});  
<!--

//-->
</script>


