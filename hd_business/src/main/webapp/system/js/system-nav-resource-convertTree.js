function convert(rows){    
        function exists(rows, parentId){    
            for(var i=0; i<rows.length; i++){    
                if (rows[i].id == parentId) return true;    
            }    
            return false;    
        }
        
        function existsChild(rows,id){
            for(var i=0; i<rows.length; i++){    
                if (rows[i].parentId == id) return true;    
            }    
            return false;   
        }
        var nodes = [];    
        // 得到顶层节点  
        for(var i=0; i<rows.length; i++){    
            var row = rows[i];    
            if (!exists(rows, row.parentId)){ //如果不存在父节点
            	if(existsChild(rows,row.id)){//如果存在子节点
            		 nodes.push({    
                         id:row.id,    
                         text:row.text,
                         state:"closed",
                         checked:false,
                         iconCls:row.iconCls,
                         parentId:row.parentId,
                         resourcesId:row.resourcesId,
                         resourcesName:row.resourcesName,
                         resourcesType:row.resourcesType,
                         resourcesParent:row.resourcesParent,
                         resourcesLink:row.resourcesLink,
                         resourcesNote:row.resourcesNote,
                         resourcesCode:row.resourcesCode,
                         attributes:row.attributes,
                         rank:row.rank
                     });    
            	}
            	else{
            		nodes.push({    
            			 id:row.id,    
                         text:row.text,
                         state:"open",
                         checked:row.checked,
                         iconCls:row.iconCls,
                         parentId:row.parentId,
                         resourcesId:row.resourcesId,
                         resourcesName:row.resourcesName,
                         resourcesType:row.resourcesType,
                         resourcesParent:row.resourcesParent,
                         resourcesLink:row.resourcesLink,
                         resourcesNote:row.resourcesNote,
                         resourcesCode:row.resourcesCode,
                         attributes:row.attributes,
                         rank:row.rank
                    });  
            	}
            }    
        }    
            
        var toDo = [];    
        for(var i=0; i<nodes.length; i++){    
            toDo.push(nodes[i]);    
        }    
        while(toDo.length){    
            var node = toDo.shift();    // 父节点   
            // 得到子节点   
            for(var i=0; i<rows.length; i++){    
                var row = rows[i];    
                if (row.parentId == node.id){  
                	var child = null;
                	if(existsChild(rows,row.id)){
                		child = {
                				 id:row.id,    
                                 text:row.text,
                                 state:"closed",
                                 checked:false,
                                 iconCls:row.iconCls,
                                 parentId:row.parentId,
                                 resourcesId:row.resourcesId,
                                 resourcesName:row.resourcesName,
                                 resourcesType:row.resourcesType,
                                 resourcesParent:row.resourcesParent,
                                 resourcesLink:row.resourcesLink,
                                 resourcesNote:row.resourcesNote,
                                 resourcesCode:row.resourcesCode,
                                 attributes:row.attributes,
                                 rank:row.rank
                    		};    
                	}
                	else{
                		child = {
                				 id:row.id,    
                                 text:row.text,
                                 state:"open",
                                 checked:row.checked,
                                 iconCls:row.iconCls,
                                 parentId:row.parentId,
                                 resourcesId:row.resourcesId,
                                 resourcesName:row.resourcesName,
                                 resourcesType:row.resourcesType,
                                 resourcesParent:row.resourcesParent,
                                 resourcesLink:row.resourcesLink,
                                 resourcesNote:row.resourcesNote,
                                 resourcesCode:row.resourcesCode,
                                 attributes:row.attributes,
                                 rank:row.rank
                        		};   
                	}
                    
                    	
                    if (node.children){    
                        node.children.push(child);    
                    } else {    
                        node.children = [child];    
                    }    
                    toDo.push(child);    
                }    
            }    
        }    
        return nodes;    
    }    