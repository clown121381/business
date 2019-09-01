/**
 * 提示，语言来自ecs语言包
 */
var ECSINFO = {};
ECSINFO.add = $.operator.add;
ECSINFO.update = $.operator.update;
ECSINFO.del = $.operator.del;
ECSINFO.view = $.operator.view;
ECSINFO.editView = $.operator.editView;
ECSINFO.gene = $.operator.gene;
ECSINFO.exp = $.operator.exp;

ECSINFO.acceptance = $.operator.acceptance;
ECSINFO.failure = $.operator.failure;
ECSINFO.ok = $.operator.ok;


ECSINFO.alert_system_error = function() {
	$.messager.alert($.ecs.prompt.title, $.operator.exception.systemError);
};
ECSINFO.alert_update_unique = function() {
	$.messager.alert($.ecs.prompt.title, $.operator.exception.choseMoreError);
};
ECSINFO.alert_update_notnull = function() {
	$.messager.alert($.ecs.prompt.title, $.operator.exception.choseZeroError);
};
ECSINFO.alert_delete_requried = function() {
	$.messager.alert($.ecs.prompt.title, $.operator.exception.choseRequried);
};
ECSINFO.alert_delete_permission = function() {
	$.messager.alert($.ecs.prompt.title, "您所删除的权限已分配给相关角色，请先删除角色！");
};
ECSINFO.confirm_delete = function(fun) {
	$.messager.confirm($.ecs.prompt.title, $.ecs.prompt.confirm,
			function(state) {
				if (state) {
					fun();
				}
			});
};


ECSINFO.confirm_acceptance = function(fun) {
	$.messager.confirm($.ecs.prompt.title, $.ecs.prompt.acceptance,
			function(state) {
				if (state) {
					fun();
				}
			});
};


/**
 * 显示添加成功
 */
ECSINFO.showAddSuccess = function() {
	$.messager.alert($.ecs.prompt.title, $.operator.success);
};

/**
 * 显示自定义信息
 * 
 * @param message
 *            自定义信息
 */
ECSINFO.showMessage = function(message, fun) {
	if (message) {
		if (fun) {
			$.messager.alert($.ecs.prompt.title, message, null, function() {
				fun();
			});
		} else {
			$.messager.alert($.ecs.prompt.title, message);
		}
	} else {
		$.messager.alert($.ecs.prompt.title, "");
	}
};
/**
 * 时间类型util
 * @param fmt
 * @returns
 */
Date.prototype.Format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
};