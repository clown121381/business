(function($){
	$.ecs = {};
	$.ecs.prompt = {};
	$.ecs.prompt.title = "提示";
	$.ecs.prompt.rightkey="提示：请点击右键进行操作";
	$.ecs.prompt.confirm ="删除请点击【确定】 否则点击【取消】";
	$.ecs.prompt.acceptance ="受理请点击【确定】 否则点击【取消】";
	
	$.operator = {};
	$.operator.add ="添加";
	$.operator.update="修改";
	$.operator.del="删除";
	$.operator.view ="查看";
	$.operator.gene="生成";
	$.operator.exp ="导出";
	
	$.operator.acceptance="受理";
	$.operator.failure="失败";
	$.operator.ok="完成";

	
	$.operator.exception = {};
	$.operator.exception.systemError="系统异常，请稍后再试";
	$.operator.exception.choseMoreError="只能选择单条记录";
	$.operator.exception.choseZeroError ="请选择一条记录";
	$.operator.exception.choseRequried ="至少选择一条记录";
	
	
	$.resources = {};
	$.resources.rootTxt = "资源";
	$.resources.deleteRootMess = "不能删除根资源";
	$.resources.updateRootMess = "不能修改根资源";
	$.resources.moveRootMess = "不能移动根资源";
	$.resources.movenotfound="移动节点不存在";
	
})(jQuery);

