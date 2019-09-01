package com.hd_business.service;

import java.util.List;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysAuthorityResources;
import com.hd_business.bean.SysRole;

public interface SysAuthorityService {

	PageModel<SysAuthority> findPage(String authorityNameSearch, PageCondition condition);

	SysAuthority getById(String authorityId);

	List<SysAuthorityResources> getSysAuthorityResources(String authorityId);

	boolean add(SysAuthority sysAuthority, List<SysAuthorityResources> sysAuthorityResourcesList);

	boolean update(SysAuthority sysAuthority, List<SysAuthorityResources> sysAuthorityResourcesList);

	boolean existAuthorityName(String authorityName);

	void deleteAuthorityDatas(String[] deleteIds);

	List<SysAuthority> getAll();

	List<SysAuthority> getSysAuthoritysByRoleId(String roleId);

	SysRole getRoleByRoleId(String roleId);
}
