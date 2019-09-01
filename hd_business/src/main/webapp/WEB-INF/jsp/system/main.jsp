<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/page/common.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${ctx }/system/css/system-main.css">

<script type="text/javascript" src="${ctx }/common/js/iecs/ECSTab.js"></script>
<script type="text/javascript" src="${ctx }/system/js/system-main.js"></script>
<script type="text/javascript"
	src="${ctx }/system/js/system-nav-resource-convertTree.js"></script>
<script>
	$("document").ready(function() {
		$(".site").hide();
		$(".navMenu").click(function() {
			$(".navMenu").removeClass("selected");
			$(this).addClass("selected");
		});

		$("#mainTab").tabs({
			onSelect : function(title) {
				if (title == '产品配置') {
					$('#mainTab').tabs('getTab', title).panel('refresh');
				}
			}
		});

		systemMain.ctx = '${ctx}';
		var data = eval('(' + '${childResources}' + ')'); 
		
		$('#menuNav').tree({
			data : convert(data),
			animate : true,
			lines : true,
			onClick : function(node) {
				var tid = node.id;
				var isLeaf = $('#' + tid).tree('isLeaf', node.target); //是否是叶子节点
				if (isLeaf) {
					var title = node.text;
					var url = node.attributes.url;
					var tab = new ECSTab();
					tab.addTab(title, tid, url);
				}
			}
		});
		
		//内容管理，显示站点下拉框
		var selectedModel = $(".selected").attr("onclick");
		if(selectedModel && selectedModel.indexOf("RES_CMS") > -1){
			systemMain.choseModel('RES_CMS');
		}
		$("#CMS_SITE_CHANGE_INPUT").combobox({
			valueField:'siteId',
			textField:'siteName',
			url:'${ctx }/cms/siteByUser',
			onLoadSuccess:function(){
				var obj = $(this).combobox('getData')[0];
				if(obj && obj!=null){
					$(this).combobox('setValue',obj.siteId);
					$(this).combobox('options').onSelect(obj);
				}
			},
			onSelect:function(record){
				$.post('${ctx }/cms/setCurrentSite',{'siteId':record.siteId},function(r){
					if(r == 'SUCCESS'){
						$.each($('#mainTab').tabs('tabs'),function(i,val){
							var id = $(val).panel('options').id;
							var url = $(val).panel('options').url;
							var title = $(val).panel('options').title;
							if(id.indexOf('CMS')>=0){
								var tab = new ECSTab();
								tab.updateTab(url,val,title);
							}
						});
					}
				});	
				
			}
		});
	});

	//刷新标签页
	function refreshTab(title) {
		if ($('#mainTab').tabs('exists', title)) {
			$('#mainTab').tabs('getTab', title).panel('refresh');
		}
	}

	function refreshSiteInput() {
		$("#CMS_SITE_CHANGE_INPUT").combobox('reload');
	}
</script>
</head>

<body class="easyui-layout">
	<!--顶部区域-->
	<div data-options="region:'north',border:false" style="height: 88px;overflow: hidden;">
		<div
			style="background:url('${ctx}/system/images/system-top-3.gif') repeat-x;height:88px;">
			<div class="topleft">
				<ul class="nav">
					<c:forEach var="resource" items="${rootResources }"
						varStatus="step">
						<li><a href="#"
							onclick="systemMain.choseModel('${resource.resourcesid}')"
							<c:if test="${step.index==0 }"> class="navMenu  selected" </c:if>
							<c:if test="${step.index!=0 }"> class="navMenu"</c:if>> <img
								src="${ctx }${resource.geResourcesIcon.resourcesiconpath}"
								title="${resource.resourcesname}" width="45" border="0" />
								<h2>${resource.resourcesname }</h2>
						</a></li>
					</c:forEach>
				<li style="padding-top:16px;">
				<img alt="" src="${ctx}/system/images/rysh.png">
					
				</li>
				<li style="padding-top:26px;">
					<img alt="" src="${ctx}/system/images/lhglxt.png">
				</li>
				</ul>
			</div>
			<div class="topright" style="width:200px; height:88px; float:right">
				<ul>
					<li style="font-size:14px; color:#006ab3;margin-right:15px; ">用户:${userName}</li>
					<li><a href="${ctx}/userLogin.do?method=logout" style="color: #006ab3;" target="_parent">退出</a></li>
				</ul>
				<ul>
					<li style="font-size:14px; color: #006ab3;">日期:${newDate}</li>
				</ul>

			</div>
		</div>
	</div>

	<!--左部区域-->
	<div data-options="region:'west',split:false,title:' '"
		style="width: 180px;">
		<div id="menuNav" style="padding-top: 15px;"></div>

	</div>

	<!--右部区域-->
	<div data-options="region:'center'" style="vertical-align: 0px;">
		<div class="easyui-tabs" data-options="fit:true" id="mainTab"></div>
	</div>

	<!--底部区域-->
	<div data-options="region:'south',border:false"></div>
</body>
</html>