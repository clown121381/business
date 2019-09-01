package com.hd_business.service;

import java.util.List;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.bean.SysUserRole;

public interface SysUserInfoService {

	PageModel<SysUserInfo> findUsersPage(String userName, PageCondition condition);

	boolean existUserName(String userName);

	List<SysUserRole> getRoleByUserId(String userId);

	SysUserInfo getUserInfoByUserId(String userId);

	void add(SysUserInfo user, List<SysUserRole> list);

	SysUserInfo getUserByUserId(String userId);

	void update(SysUserInfo oldUser, List<SysUserRole> list);

	void deleteUserRole(List<String> ids);
}
