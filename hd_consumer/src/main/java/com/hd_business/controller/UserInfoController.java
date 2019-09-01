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
import com.hd.common.cipher.Md5Utils;
import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd.common.utils.HDJsonUtils;
import com.hd.common.utils.ServletUtils;
import com.hd.common.utils.UUID;
import com.hd.entity.business.user.UserInfoData;
import com.hd.entity.business.user.UserInfoData.UserDataRow;
import com.hd_business.bean.SysRole;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.bean.SysUserRole;
import com.hd_business.service.SysRoleService;
import com.hd_business.service.SysUserInfoService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sysUserInfo.do")
public class UserInfoController {
	
	@Autowired
	SysUserInfoService sysUserInfoService;
	@Autowired
	SysRoleService sysRoleService;
	
	@RequestMapping(params="method=userInfoManager")
	public String userInfoManager(){
		return "/system/user/user-list";
	}
	
	@RequestMapping(params="method=findUserData")
	public void findUserData(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
		String userName = request.getParameter("userName");
		PageModel<SysUserInfo> pm = sysUserInfoService.findUsersPage(userName, condition);
		UserInfoData userInfoData = new UserInfoData();
	        if (pm != null)
	        {
	            List<UserDataRow> rows = new ArrayList<UserDataRow>();
	            for (SysUserInfo sysUserInfo : pm.getRows())
	            {
	            	UserDataRow row = new UserDataRow();
	                BeanUtils.copyProperties(sysUserInfo, row);
	                rows.add(row);
	            }
	            userInfoData.setTotal(pm.getTotal() + "");
	            userInfoData.setRows(rows);
	        }
	        String result = JSONObject.fromObject(HDJsonUtils.convertJsonIncludeDate(userInfoData, "yyyy-MM-dd HH:mm:ss")).toString();
	      ServletOutputStream out = response.getOutputStream();
	      out.write(result.getBytes("UTF-8"));
	}
	
	
	@RequestMapping(params = "method=userOperate")
	public String userOperate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		String operate = request.getParameter("operate");
		request.setAttribute("operate", operate);
		if("ADD".equals(operate)){
			List<SysRole> roles = sysRoleService.getAll();// 得到所有权限,用于关联用户
			request.setAttribute("roles", roles);
		}else if("UPDATE".equals(operate)){	
			String userId = request.getParameter("userId");
			List<SysRole> allroles = sysRoleService.getAll();
			SysUserInfo userInfo = sysUserInfoService.getUserInfoByUserId(userId);
			List<SysUserRole> list =  sysUserInfoService.getRoleByUserId(userId);
			List<String> roleIds = new ArrayList<>();
			List<SysRole> unownroles = new ArrayList<>();
			for(SysUserRole r : list){
				roleIds.add(r.getRoleId());
			}
			List<SysRole> ownroles = sysRoleService.getRoles(roleIds);
			List<String> ownRoleIds = new ArrayList<>();
			for(SysRole s : ownroles){
				ownRoleIds.add(s.getRoleId());
			}
			for(SysRole s : allroles){
				if(!ownRoleIds.contains(s.getRoleId())){
					unownroles.add(s);
				}
			}
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("roles", unownroles);
			request.setAttribute("owerRoles", ownroles);
		}else if("VIEW".equals(operate)){
			String userId = request.getParameter("userId");
			SysUserInfo userInfo = sysUserInfoService.getUserInfoByUserId(userId);
			List<SysUserRole> list =  sysUserInfoService.getRoleByUserId(userId);
			List<String> roleIds = new ArrayList<>();
			for(SysUserRole r : list){
				roleIds.add(r.getRoleId());
			}
			
			List<SysRole> ownroles = sysRoleService.getRoles(roleIds);
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("owerRoles", ownroles);
			return "system/user/user-view";
		}
		return "system/user/user-addOrUpdate";
	}
	@RequestMapping(params = "method=existUserName")
	public void existUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String operate = request.getParameter("operate");
		String userName = request.getParameter("userName");

		Map<String, String> result = new HashMap<String, String>();
		if ("ADD".equals(operate)) {
			boolean boo = sysUserInfoService.existUserName(userName);
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
	
	@RequestMapping(params = "method=addOrUpdateUser")
	public void addOrUpdateUser(HttpServletRequest request, HttpServletResponse response){
		String operate = request.getParameter("operate");
		String roleIds = request.getParameter("roleIds");
		if("ADD".equals(operate)){
			try {
				Date date = new Date();
				SysUserInfo user = ServletUtils.objectMethod(SysUserInfo.class, request);
				user.setUserId(UUID.getUUID());
				user.setcTimeStamp(date);
				user.setIsDel("N");
				user.setCreateTime(date);
				if(roleIds != null && !"".equals(roleIds)){
					List<SysUserRole> list = new ArrayList<>();
					for(String roleId : roleIds.split(",")){
						SysUserRole r = new SysUserRole();
						r.setCreateTime(date);
						r.setcTimeStamp(date);
						r.setRoleId(roleId);
						r.setSysUserRoleId(UUID.getUUID());
						r.setIsDel("N");
						r.setUserId(user.getUserId());
						list.add(r);
					}
					sysUserInfoService.add(user,list);
				}else{
					sysUserInfoService.add(user,null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("UPDATE".equals(operate)){
			try {
				Date date = new Date();
				SysUserInfo newUser = ServletUtils.objectMethod(SysUserInfo.class, request);
				SysUserInfo oldUser = sysUserInfoService.getUserByUserId(newUser.getUserId());
				oldUser.setcTimeStamp(date);
				oldUser.setEmail(newUser.getEmail());
				oldUser.setPassword(Md5Utils.encrypt(newUser.getPassword()));
				oldUser.setStatus(newUser.getStatus());
				oldUser.setUserType(newUser.getUserType());
				if(roleIds != null && !"".equals(roleIds)){
					List<SysUserRole> list = new ArrayList<>();
					for(String roleId : roleIds.split(",")){
						SysUserRole r = new SysUserRole();
						r.setCreateTime(date);
						r.setcTimeStamp(date);
						r.setRoleId(roleId);
						r.setSysUserRoleId(UUID.getUUID());
						r.setUserId(oldUser.getUserId());
						r.setIsDel("N");
						list.add(r);
					}
					sysUserInfoService.update(oldUser,list);
				}else{
					sysUserInfoService.update(oldUser,null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(params = "method=deleteUserData")
	public void deleteData(HttpServletRequest request,HttpServletResponse response){
		String deleteIds = request.getParameter("deleteIds");
		List<String> ids = new ArrayList<String>();
		if (deleteIds.contains(",")) {
			String[] temp = deleteIds.split(",");
			for (String str : temp) {
				ids.add(str);
			}
		} else {
			ids.add(deleteIds);
		}
		sysUserInfoService.deleteUserRole(ids);
		try{
			ServletOutputStream out = response.getOutputStream();
			out.write("SUCCESS".getBytes("UTF-8"));
		}catch(Exception e){
			
		}
		
	}
	
	
}
