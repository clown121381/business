var Role = function(){};
Role.prototype.ctx = null;

Role.add = {
	    text: ECSINFO.add,
	    iconCls: 'icon-add',
	    handler:function(){
	    	//弹出添加角色窗口
	    	$('#role_addUpdate_window').dialog({
				width : 460,
				height : 430,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				closed: false,    
			    cache: false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:role.ctx+"/sysRole.do?method=roleOperate&operate=ADD",
				buttons:[{
					iconCls:'icon-save',
					text:ECSINFO.add,
					handler:function(){
						$('#addUpdateRoleForm').submit();
					}
				},
				{
					iconCls:'icon-cancel',
					text:'关闭',
					handler:function(){
						$('#role_addUpdate_window').window('close');
					}
				}]
				
			}).show();
	    }
};

Role.update={

	    text: ECSINFO.update,
	    iconCls: 'icon-edit',
	    handler:function(){
	    	var rows =$('#roleDatagrid').datagrid('getChecked');
	    	if(rows.length > 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	} else if(rows== null || rows.length == 0){
	    		ECSINFO.alert_update_notnull();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		//弹出添加角色窗口
	    		
	    		$('#role_addUpdate_window').dialog({
					width : 460,
					height : 430,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					href:role.ctx+"/sysRole.do?method=roleOperate&operate=UPDATE&roleId="+row.roleId,
					buttons:[{
						iconCls:'icon-edit',
						text:ECSINFO.update,
						handler:function(){
							$('#addUpdateRoleForm').submit();
						}
					},
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#role_addUpdate_window').window('close');
						}
					}]
					
				}).show();
	    	}
	    }
};


Role.del={
		text : $.operator.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#roleDatagrid").datagrid('getSelections');
			if(selections.length>=1){
			var deleteId = "";
			$(selections).each(function(index,selection){
				selection = eval(selection);
				deleteId += selection.roleId+",";
			});
			deleteIds = deleteId.substring(0,deleteId.length-1);    
				ECSINFO.confirm_delete(function(){
					$.ajax({
						url:role.ctx+"/sysRole.do?method=deleteRole",
						data:{"deleteIds":deleteIds},
						success:function(data){
							if(data == "failure"){
								ECSINFO.alert_delete_authority();
							}else{
		        				$('#roleDatagrid').datagrid('load'); 
		        				$('#roleDatagrid').datagrid('clearChecked');
							}
						//	$('#authorityData').datagrid('clearChecked');
						},
	        			error:function (XMLHttpRequest, textStatus, errorThrown){
	        				ECSINFO.alert_system_error();
	        			}
					});	    	
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
};

Role.view={

	    text: ECSINFO.view,
	    iconCls: 'icon-search',
	    handler:function(){
	    	var rows =$('#roleDatagrid').datagrid('getChecked');
	    	if(rows== null || rows.length != 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	}else{
	    		var row = rows[0];
	    		
	    		$('#role_addUpdate_window').dialog({
					width : 460,
					height : 430,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-search',
					title : ECSINFO.view,
					 href:role.ctx+"/sysRole.do?method=roleOperate&operate=VIEW&roleId="+row.roleId,
					buttons:[
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#role_addUpdate_window').window('close');
						}
					}]
					
				}).show();
	    	}
	    }
};


Role.prototype.toolbar =[];



Role.prototype.createRoleTreeGrid = function(){
	var that = this;
	that.initToolBar();
	$('#roleDatagrid').datagrid({
		fit:true,
		toolbar : that.toolbar,
		checkOnSelect:true,
		pagination : true,
		rownumbers:true,
		fitColumns:true,
		title:"",
		pageSize:20,
		pageList:[15,20,25,30],
		//idField:"roleid",
		columns : [ [
         {
 			field : 'roleId',
 			checkbox:true
 		},
		 {
			field : 'roleName',
			title : '角色名称',
			width : ($("#roleDatagrid").width() * 0.25)
		}, {
			field : 'note',
			title : '角色描述',
			width : ($("#roleDatagrid").width() * 0.25)
		}, {
			field : 'createTime',
			title : '创建时间',
			width : ($("#roleDatagrid").width() * 0.25)
		} ] ]
	});
	
	that.initOwnToolBar();
	that.loadData();
	
};

Role.prototype.initToolBar = function(){
		this.toolbar.push(Role.add);
		this.toolbar.push("-");
		this.toolbar.push(Role.update);
		this.toolbar.push("-");
		this.toolbar.push(Role.del);
		this.toolbar.push("-");
		this.toolbar.push(Role.view);
		this.toolbar.push("-");
}

Role.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar').append("<table><tr><td></td></tr></table>");
	$('#searchBar div').appendTo('.datagrid-toolbar table:last tr td');
}

/**
 * 开始加载数据
 */
Role.prototype.loadData = function(){
	var that =this;
	$('#roleDatagrid').datagrid('options').url = that.ctx+"/sysRole.do?method=getRoles";
	var pagination = $('#roleDatagrid').datagrid("getPager");
	if(pagination){
		$(pagination).pagination({
			
		});
	}
}
/**
 * 查询数据
 * @param roleName 按角色名称查询
 */
Role.prototype.searchData = function(roleName){
	if(typeof(roleName)=='undefined'){
		roleName="";
	}
	else{
		roleName=roleName.replace(/\s+/g,"");
	}
	 $('#roleDatagrid').datagrid('load',{  
	        "roleName": roleName
	 });  
}

/**
 * 添加权限
 */
Role.prototype.addAuthority = function(){
	var authoritys = $("#allAuthority option:selected");
	
	//var ownAuthoritys = $("#ownAuthority option");

	for(var i=0;i<authoritys.length;i++){
		//如果选中的已经存在
		if(typeof($("#ownAuthority option[value='"+$(authoritys[i]).val()+"']").val())!='undefined'){
			//alert($(authoritys[i]).val());
		}
		else{
			$("#ownAuthority").append($(authoritys[i]));
		}
		
		
	}
	
	
}
/**
 * 移除权限
 */
Role.prototype.removeAuthority = function(){
	var authoritys = $("#ownAuthority option:selected");
	for(var i=0;i<authoritys.length;i++){
		//如果选中的已经存在
		if(typeof($("#allAuthority option[value='"+$(authoritys[i]).val()+"']").val())!='undefined'){
			//alert($(authoritys[i]).val());
		}
		else{
			$("#allAuthority").append($(authoritys[i]));
		}
		
		
	}
}


/**
 * 添加或者修改角色
 */
Role.prototype.addUpdateRole = function(){
	var that = this;
	var roleName = $("#roleName").val();
	var note = $("#note").val();
	var authoritys = $("#ownAuthority option");
	var operate = $("#operate").val();
	var authorityIds = "";
	
	for(var i=0;i<authoritys.length;i++){
		if(i==authoritys.length-1){
			authorityIds=authorityIds+$(authoritys[i]).val();
		}else{
			authorityIds=authorityIds+$(authoritys[i]).val()+",";
		}
	}
	
	var data = {};
	data["roleName"]=roleName;
	data["note"]=note;
	data["operate"]=operate;
	data["authorityIds"]=authorityIds;
	data["date"]=new Date();
	
	if(operate=='UPDATE'){
		data["roleId"]=$("#roleId").val();
	}
	
	$.ajax({
		type:"POST",
		url:that.ctx+"/sysRole.do?method=addOrUpdateRole",
		data:data,
		success:function(data){
			$('#role_addUpdate_window').window('close');
			$('#roleDatagrid').datagrid('load'); 
			$('#roleDatagrid').datagrid('clearChecked');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			ECSINFO.alert_system_error();
		}
	});
	 
}

Role.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateRoleForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			roleName: [/^[^<>]+$/, '不能出现<>字符'], //自定义EL表达式
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&roleName="+$("#roleName").val()+"&date="+new Date();
				return $.ajax({
					type:"get",
					url:that.ctx+"/sysRole.do?method=existRole",
					data:data,
					success:function(data){
						return data;
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						ECSINFO.alert_system_error();
						return false;
					}
				});
			}
		},
		fields:{//那些字段要加入到规则中
			"roleName":{
				rule:"required;roleName;unique",
				tip: "不能出现<>字符"
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			}
		},
		valid: function(form){ //验证成功
			role.addUpdateRole();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
}
