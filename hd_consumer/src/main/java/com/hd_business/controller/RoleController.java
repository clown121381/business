package com.hd_business.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd.common.utils.HDJsonUtils;
import com.hd.common.utils.ServletUtils;
import com.hd.common.utils.UUID;
import com.hd.entity.business.user.RoleData;
import com.hd.entity.business.user.RoleData.RoleDataRow;
import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysRole;
import com.hd_business.bean.SysRoleAuthority;
import com.hd_business.service.SysAuthorityService;
import com.hd_business.service.SysRoleService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sysRole.do")
public class RoleController {

	@Autowired
	SysRoleService sysRoleService;

	@Autowired
	SysAuthorityService sysAuthorityService;

	@RequestMapping(params = "method=roleManager")
	public String roleManager() {
		return "/system/role/role-list";
	}

	@RequestMapping(params = "method=getRoles")
	public void searchAuthorityData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
		String roleName = request.getParameter("roleName");
		PageModel<SysRole> pm = sysRoleService.findRolePage(roleName, condition);
		RoleData roleData = new RoleData();
		if (pm != null) {
			List<RoleDataRow> rows = new ArrayList<RoleDataRow>();
			for (SysRole sysRole : pm.getRows()) {
				RoleDataRow row = new RoleDataRow();
				BeanUtils.copyProperties(sysRole, row);
				rows.add(row);
			}
			roleData.setTotal(pm.getTotal() + "");
			roleData.setRows(rows);
		}
		String result = JSONObject.fromObject(HDJsonUtils.convertJsonIncludeDate(roleData, "yyyy-MM-dd HH:mm:ss"))
				.toString();
		ServletOutputStream out = response.getOutputStream();
		out.write(result.getBytes("UTF-8"));
	}

	@RequestMapping(params = "method=roleOperate")
	public String roleOperate(HttpServletRequest request, HttpServletResponse response) {
		String operate = request.getParameter("operate");
		List<SysAuthority> allAuthoritys = sysAuthorityService.getAll();
		request.setAttribute("operate", operate);
		if ("ADD".equals(operate)) {
			request.setAttribute("authoritys", allAuthoritys);
		} else if ("VIEW".equals(operate)) {
			String roleId = request.getParameter("roleId");
			SysRole role = sysAuthorityService.getRoleByRoleId(roleId);
			List<SysAuthority> ownAuthoritys = sysAuthorityService.getSysAuthoritysByRoleId(roleId);
			List<String> ownIds = new ArrayList<>();
			for (SysAuthority a : ownAuthoritys) {
				ownIds.add(a.getAuthorityId());
			}
			List<SysAuthority> unownAuthoritys = new ArrayList<>();
			for (SysAuthority a : allAuthoritys) {
				if (!ownIds.contains(a.getAuthorityId())) {
					unownAuthoritys.add(a);
				}
			}
			request.setAttribute("owerAuthoritys", ownAuthoritys);
			request.setAttribute("authoritys", unownAuthoritys);
			request.setAttribute("role", role);
		} else if ("UPDATE".equals(operate)) {
			String roleId = request.getParameter("roleId");
			List<SysAuthority> ownAuthoritys = sysAuthorityService.getSysAuthoritysByRoleId(roleId);
			SysRole role = sysAuthorityService.getRoleByRoleId(roleId);
			List<String> ownIds = new ArrayList<>();
			for (SysAuthority a : ownAuthoritys) {
				ownIds.add(a.getAuthorityId());
			}
			List<SysAuthority> unownAuthoritys = new ArrayList<>();
			for (SysAuthority a : allAuthoritys) {
				if (!ownIds.contains(a.getAuthorityId())) {
					unownAuthoritys.add(a);
				}
			}
			request.setAttribute("owerAuthoritys", ownAuthoritys);
			request.setAttribute("authoritys", unownAuthoritys);
			request.setAttribute("role", role);
		}
		return "/system/role/role-addOrUpdate";
	}

	@RequestMapping(params = "method=existRole")
	public void existRole(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		String operate = request.getParameter("operate");
		String roleName = request.getParameter("roleName");

		Map<String, String> result = new HashMap<String, String>();
		if ("ADD".equals(operate)) {
			boolean boo = sysRoleService.existRoleName(roleName);
			;
			if (boo) { // 存在
				result.put("error", "角色已经存在");
			} else {// 不存在
				result.put("ok", "");
			}
		} else {
			result.put("ok", "");
		}

		ServletOutputStream out = response.getOutputStream();
		out.write(JSONObject.fromObject(result).toString().getBytes("UTF-8"));
	}

	@RequestMapping(params = "method=deleteRole")
	public void deleteRole(String deleteIds, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		String[] idarray = deleteIds.split(",");
		for (String s : idarray) {
			sysRoleService.deleteByRoleId(s);
		}
		ServletOutputStream out = response.getOutputStream();
		out.write("SUCCESS".getBytes("UTF-8"));
	}

	@RequestMapping(params = "method=addOrUpdateRole")
	public void addOrUpdateRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String operate = request.getParameter("operate");
		String authorityIds = request.getParameter("authorityIds");
		SysRole sysRole = new SysRole();
		Date date = new Date();
		if ("ADD".equals(operate)) {// 添加所做的操作
			try {
				sysRole = ServletUtils.objectMethod(SysRole.class, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sysRole.setCreateTime(date);
			sysRole.setcTimeStamp(date);
			sysRole.setIsDel("N");
			sysRole.setRoleId(UUID.getUUID());
			if (authorityIds != null && !"".equals(authorityIds)) {
				List<SysRoleAuthority> list = new ArrayList<>();
				for (String id : authorityIds.split(",")) {
					SysRoleAuthority s = new SysRoleAuthority();
					s.setAuthorityId(id);
					s.setCreateTime(date);
					s.setcTimeStamp(date);
					s.setIsDel("N");
					s.setRoleId(sysRole.getRoleId());
					s.setSysRoleAuthorityId(UUID.getUUID());
					list.add(s);
				}
				sysRoleService.add(sysRole, list);
			}else{
				sysRoleService.add(sysRole, null);
			}

		} else if ("UPDATE".equals(operate)) {// 修改所做的操作
			try {
				sysRole = ServletUtils.objectMethod(SysRole.class, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			SysRole oldRole = sysRoleService.getRoleById(sysRole.getRoleId());
			oldRole.setNote(sysRole.getNote());
			if(authorityIds != null && !"".equals(authorityIds)){
				List<SysRoleAuthority> list = new ArrayList<>();
				for(String id : authorityIds.split(",")){
					SysRoleAuthority s = new SysRoleAuthority();
					s.setAuthorityId(id);
					s.setcTimeStamp(date);
					s.setCreateTime(oldRole.getCreateTime());
					s.setIsDel("N");
					s.setRoleId(oldRole.getRoleId());
					s.setSysRoleAuthorityId(oldRole.getRoleId());
					list.add(s);
				}
				sysRoleService.update(oldRole,list);
			}else{
				sysRoleService.add(sysRole, null);
			}
		}
		ServletOutputStream out = response.getOutputStream();
		out.write("SUCCESS".getBytes("UTF-8"));
	}
}
