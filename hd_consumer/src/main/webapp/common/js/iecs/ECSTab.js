var ECSTab = function(){};
ECSTab.prototype.reload = false;

/**
 * 选择菜单树，添加tab页
 * @param title
 * @param id
 * @param url
 */
ECSTab.prototype.addTab = function(title,id,url){
	var exists = $("#mainTab").tabs('exists',title);
	if(!exists){
		$("#mainTab").tabs('add',{
			id:id,
			title:title,
			content:'<iframe id="'+title+'" src="'+url+'" width="100%" height="100%" align="top" scrolling="auto" frameborder="0"></iframe>',
			closable:true,
			onBeforeOpen:function(){
				//ajaxLoading();
			},
			tools:[{
				iconCls:'icon-mini-refresh',
				handler:function(){
					$('#mainTab').tabs('update', {
						tab: $('#mainTab').tabs('getTab',title),
						options: {
						}
					});

				}
			}]
		});
		
	}
	else{
		var tab = $("#mainTab").tabs('getTab',title);
		this.updateTab(url, tab,title);
		$("#mainTab").tabs('select',title);
	}
}

/**
 * 属性tab页
 * @param url
 * @param tab
 * @param title
 */
ECSTab.prototype.updateTab=function(url,tab,title) {  
	if(this.reload){
		$('#mainTab').tabs('update', {
			tab: tab,
			options: {
			}
		});
		
		 $("#"+title).attr("src",url);
	}
	else{
		$('#mainTab').tabs('update', {
			tab: tab,
			options: {
			}
		});
	}
};

