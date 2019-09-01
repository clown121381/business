var UserManage = function(){};
UserManage.prototype.ctx = null;

/**
 * 添加按钮
 */
UserManage.add =  {
		text : ECSINFO.add,
		iconCls : 'icon-add',
		handler : function() {
			
			$('#user_operate_window').dialog({
				width : 500,
				height : 420,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				closed: false,    
			    cache: false,
				iconCls : 'icon-add',
				title : ECSINFO.add,
				href:userManage.ctx+"/sysUserInfo.do?method=userOperate&operate=ADD",
				
				buttons:[{
					iconCls:'icon-save',
					text:'保存',
					handler:function(){
						$('#userManageForm').submit();
					}
				},
				{
					iconCls:'icon-cancel',
					text:'关闭',
					handler:function(){
						$('#user_operate_window').window('close');
					}
				}]
				
			}).show();
			
			
		}
};

/**
 * 更新按钮
 */
UserManage.update = {
		text : ECSINFO.update,
		iconCls : 'icon-edit',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length > 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	} else if(selections== null || selections.length == 0){
	    		ECSINFO.alert_update_notnull();
	    		return false;
			} else {
				var row = selections[0];
				
				
				$('#user_operate_window').dialog({
					width : 500,
					height : 420,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-edit',
					title : ECSINFO.update,
					href:userManage.ctx+"/sysUserInfo.do?method=userOperate&operate=UPDATE&userId=" + row.userId,
					buttons:[{
						iconCls:'icon-edit',
						text:ECSINFO.update,
						handler:function(){
							$('#userManageForm').submit();
						}
					},
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#user_operate_window').window('close');
						}
					}]
				}).show();
				
			}
		}
};

/**
 * 删除按钮
 */
UserManage.del = {
		text : ECSINFO.del,
		iconCls : 'icon-remove',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length > 0){
				var deleteName = "";
				var deleteId = "";
				$(selections).each(function(index,selection){
					selection = eval(selection);
					deleteName += selection.userName+", ";
					deleteId += selection.userId+",";
				});
				deleteName = deleteName.substring(0,deleteName.length-2);
				deleteIds = deleteId.substring(0,deleteId.length-1);
				
				ECSINFO.confirm_delete(function(){    
					$.ajax({
						url:userManage.ctx+"/sysUserInfo.do?method=deleteUserData",
						data:{"deleteIds":deleteIds},
						success:function(){
							userManage.reloadGrid();
							$('#userData').datagrid('clearSelections');  
						}
					});
				});
			}else{
				ECSINFO.alert_delete_requried();
			}
		}
};

/**
 * 查看按钮
 */
UserManage.view = {
		text : ECSINFO.view,
		iconCls : 'icon-search',
		handler : function() {
			var selections = $("#userData").datagrid('getSelections');
			if(selections.length > 1){
	    		ECSINFO.alert_update_unique();
	    		return false;
	    	} else if(selections== null || selections.length == 0){
	    		ECSINFO.alert_update_notnull();
	    		return false;
			} else {
				var row = selections[0];
				
				
				$('#user_operate_window').dialog({
					width : 500,
					height : 420,
					modal : true,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					closed: false,    
				    cache: false,
					iconCls : 'icon-search',
					title : ECSINFO.view,
					href:userManage.ctx+"/sysUserInfo.do?method=userOperate&operate=VIEW&userId=" + row.userId,
					buttons:[
					{
						iconCls:'icon-cancel',
						text:'关闭',
						handler:function(){
							$('#user_operate_window').window('close');
						}
					}]
				}).show();
				
			}
		}
};

/**
 * 工具栏
 */
 UserManage.prototype.toolbar = [];
 
 /**
  * 初始化工具栏
  */
 UserManage.prototype.initToolBar = function(){
			this.toolbar.push(UserManage.add);
			this.toolbar.push("-");
			this.toolbar.push(UserManage.update);
			this.toolbar.push("-");
			this.toolbar.push(UserManage.del);
			this.toolbar.push("-");
			this.toolbar.push(UserManage.view);
			this.toolbar.push("-");
};

/**
 * 创建用户信息数据表格
 */
UserManage.prototype.createDataGrid = function(){
	this.initToolBar();
	$('#userData').datagrid({
		toolbar : this.toolbar,
		url : userManage.ctx+'/sysUserInfo.do?method=findUserData', 
		fit : true,
		pagination:true,
		rownumbers:true,
		pageSize:20,
		pageList:[15,20,25,30],
		loading:"数据加载中...",
//		idField:"userId",
		checkbox:true,
		width : $("#userData").width(),
		fitColumns:true,
		columns : [ [ {
			field : 'userId',
			title : 'id',
			hidden: true
		}, {
			checkbox:true,
			field : 'checkbox',
			title : 'checkbox'
		}, {
			field : 'userName',
			title : '姓名',
			width : ($("#userData").width() * 0.15),
			halign: 'center',
			align:'center'
		}, {
			field : 'userType',
			title : '用户类型',
			width : ($("#userData").width() * 0.15),
			formatter: function(value){
				if("Y"==value){
					return"超级管理员";
				}else{
					return"普通管理员";
				}
			},
			halign: 'center',
			align:'center'
		}, {
			field : 'email',
			title : '邮箱',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		},{
			field : 'status',
			title : '状态',
			formatter: function(value){
				if("Y"==value){
					return"启用";
				}else{
					return"冻结";
				}
			},
			halign: 'center',
			align:'center'
		},{
			field : 'createTime',
			title : '创建时间',
			width : ($("#userData").width() * 0.2),
			halign: 'center',
			align:'center'
		} ] ]
	});
	this.initOwnToolBar();
};

/**
 * 搜索
 * @param userName
 */
UserManage.prototype.searchData = function(userName){
	if(typeof(userName)=='undefined'){
		userName="";
	}
	else{
		userName=userName.replace(/\s+/g,"");
	}
	$('#userData').datagrid('clearSelections');  
	$('#userData').datagrid('load',{
		'userName':userName
	});  
};

/**
 * 重新加载用户数据
 */
UserManage.prototype.reloadGrid = function(){
	$("#userData").datagrid('reload',{
		'userName':$("#userName-search").val()
	});
};

/**
 * 加载搜索条
 */
UserManage.prototype.initOwnToolBar = function(){
	$('.datagrid-toolbar').append("<table><tr><td></td></tr></table>");
	$('#searchBar div').appendTo('.datagrid-toolbar table:last tr td');
};

/**
 * 添加角色
 */
UserManage.prototype.addRole = function(){
	var roles = $("#allRoles option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#owerRoles option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#owerRoles").append($(roles[int]));
		}
	}
};

/**
 * 移除角色
 */
UserManage.prototype.removeRole = function(){
	var roles = $("#owerRoles option:selected");
	for ( var int = 0; int < roles.length; int++) {
		if(!typeof($("#allRoles option[value='"+$(roles[int]).val()+"']").val())!='undefined'){
			$("#allRoles").append($(roles[int]));
		}
	}
};


/**
 * 添加或修改用户
 */
UserManage.prototype.addUpdateUser = function(){
	var operate = $("#operate").val();
	var userName = $("#userName").val();
	var password = $("#password").val();
	var userType = $("#userType").val();
	var email = $("#email").val();
	var status = $("#status").val();
	var operatorname = $("#operatorname").val();
	var roles = $("#owerRoles option");
	var roleIds =""
	if(roles!=null&&roles.length>0){
		for ( var int = 0; int < roles.length; int++) {
			roleIds=roleIds+$(roles[int]).val()+",";
		}
		roleIds = roleIds.substring(0,roleIds.length-1);
	}
	var data = {};
	data["operate"]=operate;
	data["userName"]=userName;
	data["userType"]=userType;
	data["email"]=email;
	data["status"]=status;
	data["roleIds"]=roleIds;
	if($("#pwdinput:hidden").html() == undefined){
		data["password"]=password;
	} else if(operate=='ADD'){
		data["password"]=password;
	}
	if(operate=='UPDATE'){
		data["userId"]=$("#userId").val();
	}
	$.ajax({
		type:"POST",
		url:userManage.ctx+"/sysUserInfo.do?method=addOrUpdateUser",
		data:data,
		success:function(data){
			$('#user_operate_window').window('close');
			$('#userData').datagrid('reload'); 
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};

/**
 * 隐藏或显示密码输入框
 */
UserManage.prototype.opPwdInput = function(operate){
	if(operate == 'hide'){
		$('#pwdinput').hide();
		$('#password').attr("name","");
		$('#againpwd').attr("name","");
		$('#againpwdinput').hide();
		$('#canclerepwd').hide();
		$('#repwdbtn').show();
	} else {
		$('#pwdinput').show();
		$('#password').attr("name","password");
		$('#againpwd').attr("name","againpwd");
		$('#againpwdinput').show();
		$('#canclerepwd').show();
		$('#repwdbtn').hide();
	}
};

/**
 * 用户操作页面表单验证
 */
UserManage.prototype.formValidate = function(){
	$('#userManageForm').validator({
		theme: 'yellow_right',
		timely:1,
		rules:{
			userName : [/^[^<>]+$/, '不能包含<>字符'],
			againpwd : function(element, param, field) {
				if(element.value != $("#password").val()){
					return '两次输入的密码不一致';
				} else {
					return true;
				}
			},
			existUserName : function(element, param, field) { //自定义方法规则
				
				var data = "operate="+$("#operate").val()+"&userName="+$("#userName").val();
				return $.ajax({
					type:"get",
					url:userManage.ctx+"/sysUserInfo.do?method=existUserName",
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
//	留着参考	phone: function(element, param, field) {
//				if(/^1[3458]\d{9}$/.test(element.value)){
//					return true;
//				} else if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(element.value)){
//					return true;
//				} else {
//					return '不是有效的电话号码';
//				}
//		    }
		},
		fields:{
			"userName":{
				rule:"required;length[2~15];userName;existUserName;",
				tip: "不能包含<>字符"
				//ok:""
			},
			"password":{
				rule:"required;password;",
				tip:"由6到16位字母或数字组成"
				//ok:""
			},
			"againpwd":{
				rule:"required;againpwd;",
				tip:"请再次确认密码"
				//ok:""
			},
			"email":{
				rule:"email;",
				tip:"电子邮箱"
			}
		},
		valid: function(form){ //验证成功
			userManage.addUpdateUser();
			return false;
		},
		invalid: function(form){//验证失败
			$('#user_operate').tabs('select',0);
			return false;
		}
	});
};

var userManage = new UserManage();