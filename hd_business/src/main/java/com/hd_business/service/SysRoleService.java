package com.hd_business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysRole;
import com.hd_business.bean.SysRoleAuthority;

@Service
public interface SysRoleService {

	PageModel<SysRole> findRolePage(String roleName, PageCondition condition);

	boolean existRoleName(String roleName);

	void deleteByRoleId(String s);

	void add(SysRole sysRole, List<SysRoleAuthority> list);

	
	SysRole getRoleById(String roleId);

	void update(SysRole oldRole, List<SysRoleAuthority> newAuthorityIds);

	List<SysRole> getAll();

	List<SysRole> getRoles(List<String> roleIds);
	
}
