var Resource = function(){};
Resource.checkRow = null; //鼠标选择表格那一项
Resource.prototype.ctx = null;
/**
 * 在工具栏显示提示
 */
Resource.prototype.toolbar =[
	 {
        text: '<font color="red">'+$.ecs.prompt.rightkey+'</font>',
        iconCls: 'icon-tip'
    }
];

/**
 * 创建资源表格树
 * @param jsonData json类型数据
 */
Resource.prototype.createResourceTreeGrid = function(jsonData){
	var that = this;
	jsonData.push({
		id:"0",    
        text:$.resources.rootTxt,
        state:"open",
        checked:false,
        iconCls:"",
        parentId:"-1",
        resourcesId:"0",
        resourcesName:$.resources.rootTxt,
        resourcesType:"M",
        resourcesParent:"-1",
        resourcesLink:"",
        resourcesNote:"",
        resourcesCode:"0",
        attributes:"",
        rank:"0"
	});
	
	$('#resourceList').treegrid({
	    data: convert(jsonData),
	    idField:'resourcesCode',    
	    treeField:'text',
	    title:"",
	    toolbar:that.toolbar,
	    fit:true,
	    fitColumns:true,
	    
	    onContextMenu:function(event,row){ //弹出菜单按钮
	    	Resource.checkRow = row;
	    	event.preventDefault();
	    	$('#resource_menu').menu('show',{
	    		left: event.pageX,
	    		top: event.pageY
	    	});
	    	
	    },
	    onDrop:function (targetNode, source, point){
	    	alert(point);
	    },
	    columns:[[    
	        {field:'text',title:'资源名称',width:($('#resourceList').width()*0.2),align:'left'},    
	        {field:'resourcesType',title:'资源类型',width:($('#resourceList').width()*0.1),align:'center',
	        	formatter:function(index,row){
	        		if(row.resourcesCode=='0'){
	        			return "";
	        		}
	        		else{
	        			return row.resourcesType;
	        		}
					
	        	}
	        },    
	        {field:'resourcesCode',title:'资源编码',width:($('#resourceList').width()*0.1),align:'left',
	        	formatter:function(index,row){
	        		if(row.resourcesCode=='0'){
	        			return "";
	        		}
	        		else{
	        			return row.resourcesCode;
	        		}
	        	}
	        },
	        {field:'resourcesLink',title:'资源内容',width:($('#resourceList').width()*0.2),align:'left'} ,
	        {field:'resourcesNote',title:'资源描述',width:($('#resourceList').width()*0.2),align:'left'},
	        {field:'rank',title:'资源排序',width:($('#resourceList').width()*0.1),align:'left',
	        	formatter:function(index,row){
	        		if(row.resourcesCode=='0'){
	        			return "";
	        		}
	        		else{
	        			return row.rank;
	        		}
	        	}	
	        }
	    ]]    
	}); 
	
};




/**
 * 弹出菜单选项
 * @param item
 */
Resource.prototype.selectMenu = function(item){
	if(item.name=='addResourceMenu'){
		$('#resource_addUpdate_window').dialog({
			width : 600,
			height : 360,
			modal : true,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			closed: false,    
		    cache: false,
			iconCls : 'icon-add',
			title : $.operator.add,
			href:resource.ctx+"/sysResources.do?method=jumpResourceAddOrUpdatePage",
			onLoad:function(){
		    	$("#resourcesCode").removeAttr("readonly");
				$("#resourcesCodeSpan").hide();
				$("#resourcesCode").show();
				$("#opeartype").val("ADD");//操作类型为添加
				$("#resourcesParentName").html(Resource.checkRow.text); //父资源名称
				$("#resourcesParent").val(Resource.checkRow.resourcesCode);//父资源编码
				if(Resource.checkRow.resourcesCode != '0'){
					$("#resourcesCode").val(Resource.checkRow.resourcesCode+"_");
				}
				$("#rank").val(Resource.checkRow.rank);
				
		    },
			buttons:[{
				iconCls:'icon-save',
				text:'保存',
				handler:function(){
					$('#addUpdateResouceForm').submit();
				}
			},
			{
				iconCls:'icon-cancel',
				text:'关闭',
				handler:function(){
					$('#resource_addUpdate_window').window('close');
				}
			}]
			
		}).show();
		
		
	}
	else if(item.name=='updateResourceMenu'){
		
		if(Resource.checkRow.resourcesCode == '0'){
			$.messager.alert($.ecs.prompt.title,$.resources.updateRootMess);
			return false;
		}
		
		
		$('#resource_addUpdate_window').dialog({
			width : 600,
			height : 360,
			modal : true,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			closed: false,    
		    cache: false,
			iconCls : 'icon-add',
			title : $.operator.add,
			href:resource.ctx+"/sysResources.do?method=jumpResourceAddOrUpdatePage",
		    onLoad:function(){    
				$("#resourcesCode").attr("readonly","readonly");
				$("#resourcesCode").hide();
				$("#resourcesCodeSpan").show();
				$("#resourcesCodeSpan").text(Resource.checkRow.resourcesCode);
				$("#opeartype").val("UPDATE");//操作类型为修改
				$("#updateOpearHide").hide();//修改的时候隐藏父资源名称
				$("#resourcesParent").val(Resource.checkRow.resourcesParent);//父资源编号
				$("#resourcesId").val(Resource.checkRow.resourcesId);//资源编号
				$("#resourcesCode").val(Resource.checkRow.resourcesCode);//资源编码
				$("#resourcesName").val(Resource.checkRow.resourcesName);//资源名称
				$("#resourcesType").val(Resource.checkRow.resourcesType);//资源类型
				$("#resourcesLink").val(Resource.checkRow.resourcesLink)//资源内容;
				$("#resourcesNote").val(Resource.checkRow.resourcesNote)//资源描述;
				$("#rank").val(Resource.checkRow.rank);
				
		    },
			buttons:[{
				iconCls:'icon-save',
				text:'保存',
				handler:function(){
					$('#addUpdateResouceForm').submit();
				}
			},
			{
				iconCls:'icon-cancel',
				text:'关闭',
				handler:function(){
					$('#resource_addUpdate_window').window('close');
				}
			}]
			
		}).show();
		
		
	}
	//删除资源
	else if(item.name=='delResourceMenu'){
		
		if(Resource.checkRow.resourcesCode == '0'){
			$.messager.alert($.ecs.prompt.title,$.resources.deleteRootMess);
			return false;
		}
		
		//获取子节点  getChildren
		var nodes = $('#resourceList').treegrid('getChildren',Resource.checkRow.resourcesCode);//展开父节点
		if(nodes == 0){ //没有子节点就允许删除
			 $.messager.confirm('友情提示', '您确定要删除该节点?', function(boo){  
	                if (boo){  
	                	resource.deleteResource(Resource.checkRow.resourcesId);
	                }  
	            });  
		
		}
		else{
			$.messager.alert('提示','该节点存在子节点，请先删除子节点');
		}
	}
    //移动
	else if(item.name=='moveResourceMenu'){

	
		if(Resource.checkRow.resourcesCode == '0'){ //没有子节点就允许删除
			$.messager.alert($.ecs.prompt.title,$.resources.moveRootMess);
			return false;
		}
		//打开窗口
		
		$('#resource_addUpdate_window').dialog({
			width : 600,
			height : 360,
			modal : true,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			closed: false,    
		    cache: false,
			iconCls : 'icon-add',
			title : $.operator.add,
			href:'../system/jumpResourceMovePage?childResourceCode='+Resource.checkRow.resourcesCode,
		    onLoad:function(){    
		    	$.ajax({
					type:"POST",
					url:"../system/getMoveResourceTree?childResourceCode="+Resource.checkRow.resourcesCode,
					success:function(data){
						
						data.push({
							id:"0",    
					        text:$.resources.rootTxt,
					        state:"open",
					        checked:false,
					        iconCls:"",
					        parentId:"-1",
					        resourcesId:"0",
					        resourcesName:$.resources.rootTxt,
					        resourcesType:"M",
					        resourcesParent:"-1",
					        resourcesLink:"",
					        resourcesNote:"",
					        resourcesCode:"0",
					        attributes:"",
					        rank:"0"
						});
						
						$('#resourceMoveList').tree({    
							data: convert(data),
							animate:true,
							lines:true,
							checkbox:true,
							cascadeCheck:false,
							onCheck:function(node,checked){
								var nodes = $("#resourceMoveList").tree('getChecked');
								if(checked){
									for(var i=0;i<nodes.length;i++){
										if(node.id != nodes[i].id ){
											$("#resourceMoveList").tree('uncheck',nodes[i].target);
										}
										else{
											
										}
									}
								}

							}
						});
						
						var node = $('#resourceMoveList').tree("find",Resource.checkRow.resourcesCode);
						$('#resourceMoveList').tree("remove",node.target);
						
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){
						$.messager.alert('系统异常','系统异常,请稍后再试');
					}
				});
				
		    },
			buttons:[{
				iconCls:'icon-save',
				text:'移动',
				handler:function(){
					resource.moveResource(Resource.checkRow.resourcesCode);
				}
			},
			{
				iconCls:'icon-cancel',
				text:'关闭',
				handler:function(){
					$('#resource_addUpdate_window').window('close');
				}
			}]
			
		}).show();
		
	}
	
	
};


/**
 * 按资源编号移动资源
 * @param childResourceCode 待移动资源编号
 */
Resource.prototype.moveResource = function(childResourceCode){
	if(childResourceCode == ''){
		$.messager.alert($.ecs.prompt.title,$.resources.movenotfound);
	}
	var that = this;
	var nodes = $("#resourceMoveList").tree('getChecked');
	if(nodes.length ==0){
		$.messager.alert($.ecs.prompt.title,$.operator.exception.choseZeroError);
		return false;
	}
	if(nodes.length >1){
		$.messager.alert($.ecs.prompt.title,$.operator.exception.choseMoreError);
		return false;	
	}
	else{
		
		$.ajax({
			type:"get",
			url:that.ctx+"/system/saveMoveResource?childResourceCode="+childResourceCode+"&parentResourceCode="+nodes[0].id,
			success:function(data){
				if(data =='MOVE_SUCCESS'){
					location.reload() ;
					
					$('#resource_addUpdate_window').window('close');
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown){
				$.messager.alert('系统异常','系统异常,请稍后再试');
			}
		});
	}
	
};





/**
 * 按资源编号删除资源
 * @param id 资源编号
 */
Resource.prototype.deleteResource = function(id){
	var that = this;
	var data = "resourcesId="+id+"&date="+new Date();
	
	$.ajax({
		type:"get",
		url:that.ctx+"/sysResources.do?method=deleteResource",
		data:data,
		success:function(data){
			if(data =='DEL_SUCCESS'){
				 $('#resourceList').treegrid('remove',Resource.checkRow.resourcesCode);
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
};




/**
 * 添加或者修改资源
 */
Resource.prototype.addUpdateResource =  function(){
	
	
	
	var that = this;
	var resourcesName = $("#resourcesName").val();
	var resourcesType =  $("#resourcesType").val();
	var resourcesParent =  $("#resourcesParent").val();
	var resourcesLink =  $("#resourcesLink").val();
	var resourcesNote =  $("#resourcesNote").val();
	var resourcesCode =  $("#resourcesCode").val();
	var resourcesId =  $("#resourcesId").val();
	var opeartype = $("#opeartype").val();//操作类型：删除 、更新
	var rank = $("#rank").val();
	
	var data = {};
	data["resourcesName"]=resourcesName;
	data["resourcesType"]=resourcesType;
	data["resourcesParent"]=resourcesParent;
	data["resourcesLink"]=resourcesLink;
	data["resourcesNote"]=resourcesNote;
	data["resourcesCode"]=resourcesCode;
	data["resourcesId"]=resourcesId;
	data["rank"]=rank;
	data["date"]=new Date();
	data["opeartype"]=opeartype;
	$.ajax({
		type:"post",
		url:that.ctx+"/sysResources.do?method=addUpdateResource",
		data:data,
		success:function(data){
			if(data == 'ADD_SUCCESS'){
				//添加
				$('#resourceList').treegrid('append',{
					parent: Resource.checkRow.resourcesCode,  
					data: [{
						
						id:resourcesCode,
						text: resourcesName,
						resourcesName:resourcesName,
						resourcesParent:resourcesParent,
						resourcesType:resourcesType,
						resourcesCode:resourcesCode,
						resourcesLink:resourcesLink,
						resourcesNote:resourcesNote,
						rank:rank
						
					}]
				});
				$('#resourceList').treegrid('expand',Resource.checkRow.resourcesCode);//展开父节点
				$('#resource_addUpdate_window').window('close');
			}
			if(data == 'UPDATE_SUCCESS'){
				
				//更新
				$('#resourceList').treegrid('update',{
					id: resourcesCode,
					row: {
						id:resourcesCode,
						text: resourcesName,
						resourcesName:resourcesName,
						resourcesType:resourcesType,
						resourcesCode:resourcesCode,
						resourcesLink:resourcesLink,
						resourcesNote:resourcesNote,
						rank:rank
					}
				});
				$('#resource_addUpdate_window').window('close');
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown){
			$.messager.alert('系统异常','系统异常,请稍后再试');
		}
	});
	
}



/**
 * 选择资源图标
 * @param e 当前节点
 * @param id 图标编号
 */
Resource.prototype.selectResourceIcon = function selectResourceIcon(e,id){
	$(".resourceIconItem").css("border","1px solid #96CB55");
	$(e).css("border","1px solid red");
	$("#resourcesicon").html($(e).html());
}


Resource.prototype.formValidate = function(){
	var that = this;
	$('#addUpdateResouceForm').validator({
		theme: 'yellow_right',//主题
		timely:1,//0 || false: 关闭实时验证，将只在提交表单的时候进行验证1 || true: 启用实时验证，在字段失去焦点后验证该字段 2: 启用实时验证，在输入的同时验证该字段
		rules:{ //自定义规则 有两种方式 1、EL表达式 2、自定义方法
			resourcesCode: [/^[a-zA-Z0-9_]+$/, '仅支持字母与数字下划线'], //自定义EL表达式
			resourcesCodePrefix:function(element, param, field){
				var resourcesParent =  $("#resourcesParent").val();
				var resourcesCode = $("#resourcesCode").val();
				
				var opeartype = $("#opeartype").val();//操作类型：删除 、更新
				var regex="";
				if(opeartype=="UPDATE"){
					regex = new RegExp("^"+resourcesParent);
				}
				else{
					if(resourcesParent != "0"){
						regex = new RegExp("^"+resourcesParent+"_[A-Za-z0-9_]+$");
					}
					else{
						regex = new RegExp("^[A-Za-z0-9_]+$");
					}
					
				}
					if(regex.test(resourcesCode)){
						return {"ok": ""};
					}
					else{
						if(resourcesParent != "0"){
							return {"error": "必须以"+resourcesParent+"_开头,结尾必须有字符"};
						}
						else{
						 return {"ok": ""};;
						}
					}
			},
			resourcesLink:[/^[a-zA-Z0-9_\/]+$/, '仅支持字母与数字下划线反斜杠'],
			/**
			 *@param element 当前验证的DOM元素
			 *@param param 规则传递的参数
			 *@param field 当前字段元数据
			*/
			unique:function(element, param, field){ //自定义方法规则
				var data = "opeartype="+$("#opeartype").val()+"&geResources.resourcesCode="+$("#resourcesCode").val()+"&date="+new Date();
				return $.ajax({
					type:"get",
					url:that.ctx+"/system/existResource",
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
			"geResources.resourcesCode":{
				//rule:"required;resourcesCodePrefix;resourcesCode;unique",
				rule:"required;resourcesCode",
//				rule:"required;resourcesCode;unique",
				tip: "支持字母与数字下划线"
				
			    //ok: "成功后显示"
			    //msg: {required: "全名必填!"}  覆盖默认的提示文字
			},
			"resourcesLink":{
				rule:"required"
				//tip: "仅支持字母与数字下划线反斜杠"
				
			},
			"resourcesType":{
				rule:"required"
			},
			"resourcesName":{
				rule:"required"
			}
		},
		valid: function(form){ //验证成功
			resource.addUpdateResource();
			return false;
		},
		invalid: function(form){//验证失败
			return false;
		}
		
	});
};


var resource = new Resource();
