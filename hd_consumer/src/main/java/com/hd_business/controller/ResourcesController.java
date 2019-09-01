package com.hd_business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hd.common.utils.JsonUtils;
import com.hd.common.utils.UUID;
import com.hd.entity.business.user.ResourcesTree;
import com.hd.entity.business.user.ResourcesTree.Attribute;
import com.hd_business.bean.SysResources;
import com.hd_business.service.SysResourcesService;



@Controller
@RequestMapping("/sysResources.do")
public class ResourcesController {

	@Autowired
	private SysResourcesService sysResourcesService;

	@RequestMapping(params="method=jumpResourceAddOrUpdatePage")
	public String jumpResourceAddOrUpdatePage(){
		return "/system/resource/resource-addOrUpdate";
	}
	
	
	@RequestMapping(params="method=resourceManager")
	public String resources(HttpServletRequest request,HttpServletResponse response){
		
		List<SysResources> resources = sysResourcesService.getAll();
		
		if(resources!=null && resources.size()>0){
			List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
			for (SysResources resource : resources) {
				ResourcesTree tree = new ResourcesTree();
				BeanUtils.copyProperties(resource, tree);// 同样的字段直接复制
				tree.setId(resource.getResourcesCode());
				tree.setParentId(resource.getResourcesParent());
				tree.setText(resource.getResourcesName());
				Attribute attribute = new Attribute();
				tree.setAttributes(attribute);
				if(resource.getResourcesLink().startsWith("http")){
					attribute.setUrl(resource.getResourcesLink());
				}else{
					String contextPath = request.getContextPath();
					attribute.setUrl(contextPath+resource.getResourcesLink());
				}
				resourcesTrees.add(tree);
			}
			request.setAttribute("resourceTree", JsonUtils.toJson(resourcesTrees));
		}
		return "/system/resource/resource-list";
	}
	
	
	@RequestMapping(params="method=addUpdateResource")
	public void addOrUpdate(HttpServletRequest request,HttpServletResponse response,String opeartype,SysResources resources){
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			if(resources==null){
				out.write("资源为空".getBytes("UTF-8"));
			}
			//添加资源
			if("ADD".equals(opeartype)){
				resources.setIsDel("N");
				resources.setResourcesId(UUID.getUUID());
				resources.setcTimeStamp(new Date());
				resources.setCreateTime(new Date());
				boolean b = sysResourcesService.addResource(resources);
				if(b){
					out.write("ADD_SUCCESS".getBytes());
				}
			}else{
				SysResources oldresource = sysResourcesService.getResource(resources.getResourcesId());
				resources.setCreateTime(oldresource.getCreateTime());
				resources.setcTimeStamp(new Date());
				resources.setIsDel(oldresource.getIsDel());
				boolean b = sysResourcesService.updateResource(resources);
				if(b){
					out.write("UPDATE_SUCCESS".getBytes());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params="method=deleteResource")
	public void deleteResource(HttpServletResponse response,String resourcesId){
		SysResources oldresource = sysResourcesService.getResource(resourcesId);
		oldresource.setIsDel("Y");
		sysResourcesService.updateResource(oldresource);	
		try{
			ServletOutputStream out = response.getOutputStream();
			out.write("DEL_SUCCESS".getBytes("UTF-8"));
		}catch(Exception e){
			
		}
	}
}
