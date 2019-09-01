var SystemMain = function() {
};

SystemMain.prototype.ctx = null;
/**
 * 选择模块（系统还是业务等）
 * 
 * @param modelId
 */
SystemMain.prototype.choseModel = function(modelId) {
	var that = this;
	var data = "resourcesid=" + modelId + "&date=" + new Date();
	$("#CMS_SITE_CHANGE_INPUT").parent().css("display", "none");
	if (modelId == "RES_CMS") {
		$("#CMS_SITE_CHANGE_INPUT").parent().css("display", "").css(
				"background", "url()");
		
		$("#cmsDiv").show();
	}
	$.ajax({
		type : "get",
		url : that.ctx + "/system/resourceNavTree",
		data : data,
		success : function(data) {
			$("#menuNav").tree("loadData", convert(data));

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.messager.alert('系统异常', '系统异常,请稍后再试');
		}
	});
}

SystemMain.prototype.goTab = function() {
	var tabs = $('#mainTab').tabs('tabs');
	var tab = $('#mainTab').tabs('getSelected');
	var index = $('#mainTab').tabs('getTabIndex', tab);
	var start = 0;
	if ((index + 1) == tabs.length) {
		start = 0;
	} else {
		start = index + 1;
	}
	$("#mainTab").tabs('select', start);
}

SystemMain.prototype.goBack = function() {
	var tabs = $('#mainTab').tabs('tabs');
	var tab = $('#mainTab').tabs('getSelected');
	var index = $('#mainTab').tabs('getTabIndex', tab);
	var start = 0;
	if (index == 0) {
		start = tabs.length - 1;
	} else {
		start = index - 1;
	}
	$("#mainTab").tabs('select', start);
}

SystemMain.prototype.alterInfo = function(userid) {
	$('#alterUserInfo_windows').window(
			{
				width : 380,
				height : 250,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				iconCls : 'icon-edit',
				title : '个人信息修改',
				href : "../system/alterUserInfo?geUser.userid=" + userid
						+ "&date=" + new Date()
			}).show();
	$('#alterUserInfo_windows').window("vcenter");

}

SystemMain.prototype.flushTab = function() {
	window.top.location.reload();
}

var systemMain = new SystemMain();
