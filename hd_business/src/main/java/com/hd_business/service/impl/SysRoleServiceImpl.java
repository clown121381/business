package com.hd_business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysAuthorityExample.Criteria;
import com.hd_business.bean.SysRole;
import com.hd_business.bean.SysRoleAuthority;
import com.hd_business.bean.SysRoleAuthorityExample;
import com.hd_business.bean.SysRoleExample;
import com.hd_business.dao.SysRoleAuthorityMapper;
import com.hd_business.dao.SysRoleMapper;
import com.hd_business.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysRoleAuthorityMapper sysRoleAuthorityMapper;
	@Override
	public PageModel<SysRole> findRolePage(String roleName, PageCondition condition) {
		PageModel<SysRole> pm = new PageModel<SysRole>();		
		List<SysRole> rows = sysRoleMapper.selectByPages(roleName, condition.getPageIndex()-1<0?0:condition.getPageIndex()-1, condition.getPageSize());
		pm.setRows(rows);
		pm.setPageSize(condition.getPageSize());
		pm.setPageIndex(condition.getIndex());
		SysRoleExample example = new SysRoleExample();
		if(roleName != null && roleName != ""){
			com.hd_business.bean.SysRoleExample.Criteria c = example.createCriteria();
			c.andRoleNameLike(roleName);			
		}
		int total = (int)sysRoleMapper.countByExample(example);
		pm.setTotal(total);
		return pm;
	}

	@Override
	public boolean existRoleName(String roleName) {
		List<SysRole> roles =  sysRoleMapper.selectByExample(null);
		for(SysRole r : roles){
			if(r.getRoleName().equals(roleName)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteByRoleId(String s) {
		sysRoleMapper.deleteByPrimaryKey(s);
	}

	@Override
	public void add(SysRole sysRole, List<SysRoleAuthority> list) {
		sysRoleMapper.insertSelective(sysRole);
		if(list != null){
			for(SysRoleAuthority l : list){
				sysRoleAuthorityMapper.insertSelective(l);			
			}			
		}
	}

	
	@Override
	public SysRole getRoleById(String roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public void update(SysRole oldRole, List<SysRoleAuthority> newAuthorityIds) {
		sysRoleMapper.updateByPrimaryKey(oldRole);
		SysRoleAuthorityExample example = new SysRoleAuthorityExample();
		com.hd_business.bean.SysRoleAuthorityExample.Criteria c = example.createCriteria();
		c.andRoleIdEqualTo(oldRole.getRoleId());
		sysRoleAuthorityMapper.deleteByExample(example);
		
		if(newAuthorityIds != null){
			for(SysRoleAuthority s : newAuthorityIds){
				sysRoleAuthorityMapper.insertSelective(s);
			}			
		}
	}

	@Override
	public List<SysRole> getAll() {
		return sysRoleMapper.selectByExample(null);
	}

	@Override
	public List<SysRole> getRoles(List<String> roleids) {
		if(roleids != null){
			SysRoleExample example = new SysRoleExample();
			com.hd_business.bean.SysRoleExample.Criteria c = example.createCriteria();
			c.andRoleIdIn(roleids);
			return sysRoleMapper.selectByExample(example);
		}else{
			return null;
		}
	}
}
