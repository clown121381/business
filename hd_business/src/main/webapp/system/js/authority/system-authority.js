var AuthorityManage = function(){};
AuthorityManage.prototype.ctx = null;

AuthorityManage.prototype.formatItem = function(row){
	var s = '<span style="font-weight:bold">' + row.text + '</span><br/>'
	+ '<span style="color:#888">' + row.desc + '</span>';
	return s;
};

AuthorityManage.add = {
		text : $.operator.add,
		iconCls : 'icon-add',
		handler : function() {
			$('#authorityData_add_window').dialog({
				width : 460,
				height : 460,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				closed: false,    
			    cache: false,
				iconCls : 'icon-add',
				title : $.operator.add,
				href:authority.ctx+"/sysAuthorit.do?method=authorityOperate&operate=ADD",
				buttons:[{
					iconCls:'icon-save',
					text:'保存',
					handler:function(){
						$('#addUpdateAuthorityForm').submit();
					}
				},
				{
					iconCls:'icon-cancel',
					text:'关闭',
					handler:function(){
						$('#authorityData_add_window').window('close');
					}
				}]
				
			}).show();
		}
	};


AuthorityManage.update={
		text : $.operator.update,
		iconCls : 'icon-edit',
		handler : function() {
			
			var selections = $("#authorityData").datagrid('getSelections');
			if(selections.length == 1){
				var row = selections[0];
				$('#operate').val("UPDATE");
				$('#authorityData_add_window').dialog({
					width : 460,
					height : 460,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-edit',
					title : $.operator.add,
					href:authority.ctx+"/sysAuthorit.do?method=authorityOperate&operate=UPDATE&authorityId="+row.authorityId,
					buttons:[{
						iconCls:'icon-save',
						text:$.operator.update,
						handler:function(){
							$('#addUpdateAuthorityForm').submit();
						}
					},
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#authorityData_add_window').window('close');
						}
					}]
					
				}).show();
				
				
				
			}else if(selections.length > 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	} else if(selections== null || selections.length == 0){
	    		ECSINFO.alert_update_notnull();
	    		return false;
			}
		}
	};


AuthorityManage.del = {
		text : $.operator.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#authorityData").datagrid('getSelections');
			if(selections.length>=1){
			var deleteId = "";
			$(selections).each(function(index,selection){
				selection = eval(selection);
				deleteId += selection.authorityId+",";
			});
			deleteIds = deleteId.substring(0,deleteId.length-1);    
				ECSINFO.confirm_delete(function(){
					$.ajax({
						url:authority.ctx+"/sysAuthorit.do?method=deleteAuthorityDatas",
						data:{"deleteIds":deleteIds},
						success:function(data){
							if(data == "failure"){
								ECSINFO.alert_delete_authority();
							}else{
								authority.reloadGrid();
							}
						//	$('#authorityData').datagrid('clearChecked');
						}
					});	    	
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
	};

AuthorityManage.view={
		text : $.operator.view,
		iconCls : 'icon-search',
		handler : function() {
			
			var selections = $("#authorityData").datagrid('getSelections');
			if(selections.length == 1){
				var row = selections[0];
				$('#operateType').val("VIEW");
				
				
				$('#authorityData_add_window').dialog({
					width : 460,
					height : 460,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-search',
					title : $.operator.view,
					href:authority.ctx+"/sysAuthorit.do?method=authorityOperate&operate=VIEW&authorityId="+row.authorityId,
					buttons:[
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#authorityData_add_window').window('close');
						}
					}]
					
				}).show();
				
				
				
			}else if(selections.length > 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	} else if(selections== null || selections.length == 0){
	    		ECSINFO.alert_update_notnull();
	    		return false;
			}
		}
};


/**
 * 初始化自定义工具栏（搜索框）
 */
AuthorityManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar').append("<table><tr><td></td></tr></table>");
	$('#searchBar div').appendTo('.datagrid-toolbar table:last tr td');
} ;

/**
 * 添加或修改权限
 */

AuthorityManage.prototype.addUpdateAuthority = function(){
		
	var that = this;
	var authorityName = $("#authorityName").val();
	var note = $("#note").val();
	var resources = $("#resourceTree").tree('getCheckedExt');	
	var operate = $("#operate").val();
	var resourcesId="";
	
	
	for(var i=0;i<resources.length;i++){
//		data["geResources["+i+"].resourcesid"]=resources[i].id;
		if(i == resources.length-1){
			resourcesId = resourcesId+resources[i].resourcesId;
		}else{
			resourcesId = resourcesId+resources[i].resourcesId+",";
		}
	}

	
	var data ={
			"operate":operate,
			"authorityName":authorityName,
			"note":note,
			"resourcesId":resourcesId
	};
	data["authorityId"]=$("#authorityId").val();
	
	$.ajax({
		type:"POST",
		url:authority.ctx+"/sysAuthorit.do?method=addOrUpdateAuthority&operate="+operate,
		data:data,
		success:function(data){
			$('#authorityData_add_window').window('close');
			$('#authorityData').datagrid('load'); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
}
/**
 * 保存权限
 */
AuthorityManage.prototype.saveAuthorityData = function(){
	var authorityName = $("#authorityName").val();
	var authorityDataDesc = $("#authorityDataDesc").val();
    var authorityId =$("#authorityId").val() ;
    var authorityCreateTime = Date();
	$.ajax({
		url:"../system/saveAuthorityData",
		dataType:"json",
		data:{"authorityId":authorityId,"authorityName":authorityName,"authorityDataDesc":authorityDataDesc,"authorityCreateTime":authorityCreateTime},
		success:function(data){
			data = eval(data);
			if(data.success){
				$.messager.alert("成功",data.value);
			}else{
				$.messager.alert("错误","系统错误");
			}
		}
	});
};


/**
 * 创建表格
 */
AuthorityManage.prototype.createAuthorityGrid = function(){
	authority.initToolBar();
	$('#authorityData').datagrid({
		url : this.ctx+'/sysAuthorit.do?method=searchAuthorityData',
		pageSize:20,
		pageList:[15,20,25,30],
		toolbar : authority.toolbar,
		pagination : true,
		fit:true,
		fitColumns:true,
		rownumbers:true,
		checkbox:true,
		loading:"数据加载中...",
		idField:"authorityId",
		columns : [ [ {
			field : 'authorityId',
			checkbox:true
		},{
			field : 'authorityName',
			title : '权限名称',
			width : ($("#authorityData").width() * 0.25)
		}, {
			field : 'note',
			title : '权限描述',
			width : ($("#authorityData").width() * 0.25)
		}, {
			field : 'createTime',
			title : '创建时间',
			width : ($("#authorityData").width() * 0.25)
		}] ]
	});
	authority.initOwnToolBar();
};

/**
 * 初始化基本工具栏
 */
AuthorityManage.prototype.initToolBar = function(){
		this.toolbar.push(AuthorityManage.add);
		this.toolbar.push("-");
		this.toolbar.push(AuthorityManage.update);
		this.toolbar.push("-");
		this.toolbar.push(AuthorityManage.del);
		this.toolbar.push("-");
		this.toolbar.push(AuthorityManage.view);
};

/**
 * 刷新表格
 */
AuthorityManage.prototype.reloadGrid=function(){
	$("#authorityData").datagrid('reload',{
		authorityName:$("#authorityName-search").val()
	});
};



/**
 * 关闭窗口
 */
AuthorityManage.prototype.close = function(){
	authority.reloadGrid();
	$('#authorityData_add_window').window('close');
//	$('#authorityData').datagrid('clearChecked');
};

/**
 * 搜索权限
 */
AuthorityManage.prototype.searchAuthorityData = function(){
	var authorityName = $("#authorityNameSearch").val();
	$("#authorityData").datagrid('load',{'authorityNameSearch':authorityName});
};

/**
 * 工具栏
 */
AuthorityManage.prototype.toolbar = [];
/**
 * 权限名称验证
 */
AuthorityManage.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateAuthorityForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			authorityName: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&authorityName="+$("#authorityName").val()+"&date="+new Date();
				return $.ajax({
					type:"POST",
					url:authority.ctx+"/sysAuthorit.do?method=existAuthority",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						$.messager.alert('系统异常','验证请等待');
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"authorityName":{
				rule:"required;authorityName;unique",
				tip: "不能出现<>字符"
				
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			}
		},
		valid: function(form){ //验证成功
			authority.addUpdateAuthority();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
	});
}

var authority = new AuthorityManage();
