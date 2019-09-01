package com.hd_business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd.common.utils.HDJsonUtils;
import com.hd.common.utils.JsonUtils;
import com.hd.common.utils.ServletUtils;
import com.hd.common.utils.UUID;
import com.hd.entity.business.user.AuthorityData;
import com.hd.entity.business.user.AuthorityData.AuthorityDataRow;
import com.hd.entity.business.user.ResourcesTree;
import com.hd.entity.business.user.ResourcesTree.Attribute;
import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysAuthorityResources;
import com.hd_business.bean.SysResources;
import com.hd_business.service.SysAuthorityService;
import com.hd_business.service.SysResourcesService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sysAuthorit.do")
public class AuthorityController {

	@Autowired
	SysAuthorityService sysAuthorityService;
	@Autowired
	SysResourcesService sysResourcesService;

	@RequestMapping(params = "method=authoritManager")
	public String authorityManager() {
		return "/system/authority/authority-list";
	}

	@RequestMapping(params = "method=searchAuthorityData")
	public void searchAuthorityData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
		String authorityNameSearch = request.getParameter("authorityNameSearch");
		PageModel<SysAuthority> pm = sysAuthorityService.findPage(authorityNameSearch, condition);
		AuthorityData authorityData = new AuthorityData();
		if (pm != null) {
			List<AuthorityDataRow> rows = new ArrayList<AuthorityDataRow>();
			for (SysAuthority sysAuthority : pm.getRows()) {
				AuthorityDataRow row = new AuthorityDataRow();
				BeanUtils.copyProperties(sysAuthority, row);
				rows.add(row);
			}
			authorityData.setTotal(pm.getTotal() + "");
			authorityData.setRows(rows);
		}
		String result = JSONObject.fromObject(HDJsonUtils.convertJsonIncludeDate(authorityData, "yyyy-MM-dd HH:mm:ss"))
				.toString();
		ServletOutputStream out = response.getOutputStream();
		out.write(result.getBytes("UTF-8"));
	}

	@RequestMapping(params = "method=addOrUpdateAuthority")
	public String addOrUpdateAuthority(HttpServletRequest request, HttpServletResponse response) {
		String operate = request.getParameter("operate");
		String resourcesId = request.getParameter("resourcesId");
		String authorityId = request.getParameter("authorityId");
		SysAuthority sysAuthority = new SysAuthority();
		try {
			sysAuthority = ServletUtils.objectMethod(SysAuthority.class, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if ("ADD".equals(operate))
	        {// 增加的情况
			 System.out.println("++++++++++++++++++++++++++++++++");
	            Date date = new Date();
	            sysAuthority.setAuthorityId(UUID.getUUID());
	            sysAuthority.setIsDel("N");
	            sysAuthority.setcTimeStamp(date);
	            sysAuthority.setCreateTime(date);
	            List<SysAuthorityResources> sysAuthorityResourcesList = new ArrayList<SysAuthorityResources>();
	            if (resourcesId != null && !"null".equals(resourcesId) && !"".equals(resourcesId))
	            {
	                String[] resourcesIds = resourcesId.split(",");
	                for (String id : resourcesIds)
	                {
	                    SysAuthorityResources sysAuthorityResources = new SysAuthorityResources();
	                    sysAuthorityResources.setSysRoleAuthorityId(UUID.getUUID());
	                    sysAuthorityResources.setAuthorityId(sysAuthority.getAuthorityId());
	                    sysAuthorityResources.setResourcesId(id);
	                    sysAuthorityResources.setCreateTime(date);
	                    sysAuthorityResources.setcTimeStamp(date);
	                    sysAuthorityResources.setIsDel("N");
	                    sysAuthorityResourcesList.add(sysAuthorityResources);
	                }
	            }
	            this.sysAuthorityService.add(sysAuthority, sysAuthorityResourcesList);
	        }
	        else if ("UPDATE".equals(operate))
	        {// 修改的情况
	            Date date = new Date();
	            String authorityName = request.getParameter("authorityName");
	            SysAuthority authority = this.sysAuthorityService.getById(authorityId);
	            authority.setAuthorityName(authorityName);
	            authority.setcTimeStamp(date);
	            List<SysAuthorityResources> sysAuthorityResourcesList = new ArrayList<SysAuthorityResources>();
	            if (resourcesId != null && !"null".equals(resourcesId) && !"".equals(resourcesId))
	            {
	                String[] resourcesIds = resourcesId.split(",");
	                for (String id : resourcesIds)
	                {
	                    SysAuthorityResources sysAuthorityResources = new SysAuthorityResources();
	                    sysAuthorityResources.setSysRoleAuthorityId(UUID.getUUID());
	                    sysAuthorityResources.setAuthorityId(sysAuthority.getAuthorityId());
	                    sysAuthorityResources.setResourcesId(id);
	                    sysAuthorityResources.setCreateTime(date);
	                    sysAuthorityResources.setcTimeStamp(date);
	                    sysAuthorityResources.setIsDel("N");
	                    sysAuthorityResourcesList.add(sysAuthorityResources);
	                }
	            }
	            this.sysAuthorityService.update(sysAuthority, sysAuthorityResourcesList);
	        }
		return "/system/authority/authority-addOrUpdate";
	}

	@RequestMapping(params = "method=authorityOperate")
	public String authorityOperate(HttpServletRequest request, HttpServletResponse response) {

		String operate = request.getParameter("operate");
		String authorityId = request.getParameter("authorityId");
		request.setAttribute("operate", operate);
		if (!"ADD".equals(operate) && authorityId != null) {
			SysAuthority authority = this.sysAuthorityService.getById(authorityId);
			request.setAttribute("authority", authority);
		}
		return "/system/authority/authority-addOrUpdate";
	}

	
	private boolean isExistResource(List<SysAuthorityResources> geResources, String resourceid) {
		Iterator<SysAuthorityResources> iterator = geResources.iterator();
		while (iterator.hasNext()) {
			if (resourceid.equals(iterator.next().getResourcesId())) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(params = "method=getResourceTree")
	public void getResourceTree(HttpServletRequest request, HttpServletResponse response) {
		List<ResourcesTree> resourcesTrees = new ArrayList<ResourcesTree>();
		List<SysResources> sysResourcesList = this.sysResourcesService.getAll();
		String contextPath = request.getSession().getServletContext().getContextPath();
		if ("UPDATE".equals(request.getParameter("operate"))) {
			String authorityId = request.getParameter("authorityId");
			List<SysAuthorityResources> sysAuthorityResources = this.sysAuthorityService
					.getSysAuthorityResources(authorityId);
			for (SysResources resource : sysResourcesList) {
				ResourcesTree tree = new ResourcesTree();
				BeanUtils.copyProperties(resource, tree);// 同样的字段直接复制
				tree.setId(resource.getResourcesCode());
				tree.setParentId(resource.getResourcesParent());
				tree.setText(resource.getResourcesName());
				tree.setChecked(false);
				Attribute attribute = new Attribute();
				attribute.setUrl(contextPath + resource.getResourcesLink());
				tree.setAttributes(attribute);
				if (this.isExistResource(sysAuthorityResources, resource.getResourcesId())) {
					tree.setChecked(true);
				} else {
					tree.setChecked(false);
				}
				resourcesTrees.add(tree);
			}
		} else if ("VIEW".equals(request.getParameter("operate"))) {
			String authorityId = request.getParameter("authorityId");
			List<SysAuthorityResources> sysAuthorityResourceslist = this.sysAuthorityService
					.getSysAuthorityResources(authorityId);
			List<String> strs = new ArrayList<String>();
			for (SysAuthorityResources sysAuthorityResources : sysAuthorityResourceslist) {
				strs.add(sysAuthorityResources.getResourcesId());
			}
			sysResourcesList = null;
			sysResourcesList = this.sysResourcesService.findByResourcesIds(strs);
			for (SysResources resource : sysResourcesList) {
				ResourcesTree tree = new ResourcesTree();
				BeanUtils.copyProperties(resource, tree);// 同样的字段直接复制
				tree.setId(resource.getResourcesCode());
				tree.setParentId(resource.getResourcesParent());
				tree.setText(resource.getResourcesName());
				Attribute attribute = new Attribute();
				attribute.setUrl(contextPath + resource.getResourcesLink());
				tree.setAttributes(attribute);
				resourcesTrees.add(tree);
			}
		} else {
			for (SysResources resource : sysResourcesList) {
				ResourcesTree tree = new ResourcesTree();
				BeanUtils.copyProperties(resource, tree);// 同样的字段直接复制
				tree.setId(resource.getResourcesCode());
				tree.setParentId(resource.getResourcesParent());
				tree.setText(resource.getResourcesName());
				Attribute attribute = new Attribute();
				attribute.setUrl(contextPath + resource.getResourcesLink());
				tree.setAttributes(attribute);
				resourcesTrees.add(tree);
			}
		}

		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			out.write(JsonUtils.toJson(resourcesTrees).getBytes("UTF-8"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	  @RequestMapping(params = "method=existAuthority")
	    public void existAuthority(HttpServletRequest request, HttpServletResponse response)
	    {

	        Map<String, String> result = new HashMap<String, String>();
	        String authorityName = request.getParameter("authorityName");
	        if ("ADD".equals(request.getParameter("operate")))
	        {
	            boolean boo = this.sysAuthorityService.existAuthorityName(authorityName);
	            if (boo)
	            { // 存在
	                result.put("ok", "");
	            }
	            else
	            {// 不存在
	                result.put("error", "权限已经存在");
	            }
	        }
	        else
	        {
	            result.put("ok", "");
	        }
	        try{
	        	ServletOutputStream out = response.getOutputStream();
	        	out.write(JsonUtils.toJson(result).toString().getBytes("UTF-8"));
	        }catch(Exception e){
	        	      
	        }
	    }
	  
	  
	  @RequestMapping(params="method=deleteAuthorityDatas")
	  public void deleteAuthorityDatas(HttpServletRequest request,HttpServletResponse response,String deleteIds){
		  String[] deleteArray = deleteIds.split(",");
		  sysAuthorityService.deleteAuthorityDatas(deleteArray);
	  }
}
