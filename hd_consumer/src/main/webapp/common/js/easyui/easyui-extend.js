$(function(){
				$.extend($.fn.tree.methods,{
					getCheckedExt: function(jq){
						var checked = $(jq).tree("getChecked", ['checked','indeterminate']);                     //获取选中的选项 也就是打钩的 
						return checked;
					}
				});
				
				
});