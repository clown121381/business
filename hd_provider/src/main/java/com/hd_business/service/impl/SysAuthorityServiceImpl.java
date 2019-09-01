package com.hd_business.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysAuthorityExample;
import com.hd_business.bean.SysAuthorityExample.Criteria;
import com.hd_business.bean.SysAuthorityResources;
import com.hd_business.bean.SysAuthorityResourcesExample;
import com.hd_business.bean.SysRole;
import com.hd_business.bean.SysRoleAuthority;
import com.hd_business.bean.SysRoleAuthorityExample;
import com.hd_business.dao.SysAuthorityMapper;
import com.hd_business.dao.SysAuthorityResourcesMapper;
import com.hd_business.dao.SysRoleAuthorityMapper;
import com.hd_business.dao.SysRoleMapper;
import com.hd_business.service.SysAuthorityService;

@Service
@Component
public class SysAuthorityServiceImpl implements SysAuthorityService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	SysAuthorityMapper sysAuthorityMapper;
	@Autowired
	SysAuthorityResourcesMapper sysAuthorityResourcesMapper;
	@Autowired
	SysRoleAuthorityMapper sysRoleAuthorityMapper;
	@Autowired
	SysRoleMapper sysRoleMapper;
	@Override
	public PageModel<SysAuthority> findPage(String authorityNameSearch, PageCondition condition) {
		PageModel<SysAuthority> pm = new PageModel<SysAuthority>();		
		List<SysAuthority> rows = sysAuthorityMapper.selectByPages(authorityNameSearch, condition.getPageIndex()-1<0?0:condition.getPageIndex()-1, condition.getPageSize());
		pm.setRows(rows);
		pm.setPageSize(condition.getPageSize());
		pm.setPageIndex(condition.getIndex());
		SysAuthorityExample example = new SysAuthorityExample();
		if(authorityNameSearch != null && authorityNameSearch != ""){
			Criteria c = example.createCriteria();
			c.andAuthorityNameLike(authorityNameSearch);			
		}
		int total = (int)sysAuthorityMapper.countByExample(example);
		pm.setTotal(total);
		return pm;
	}
	@Override
	public SysAuthority getById(String authorityId) {
		return sysAuthorityMapper.selectByPrimaryKey(authorityId);
	}
	@Override
	public List<SysAuthorityResources> getSysAuthorityResources(String authorityId) {
		SysAuthorityResourcesExample example = new SysAuthorityResourcesExample();
		com.hd_business.bean.SysAuthorityResourcesExample.Criteria c = example.createCriteria();
		c.andAuthorityIdEqualTo(authorityId);
		return sysAuthorityResourcesMapper.selectByExample(example);
	}
	@Override
	public boolean add(SysAuthority sysAuthority, List<SysAuthorityResources> sysAuthorityResourcesList) {
		int flag = 0;
		flag = sysAuthorityMapper.insertSelective(sysAuthority);
		if(sysAuthorityResourcesList != null){
			for(SysAuthorityResources r : sysAuthorityResourcesList){
				flag = sysAuthorityResourcesMapper.insertSelective(r);
			}
		}
		return flag != 0?true:false;
	}
	@Override
	public boolean update(SysAuthority sysAuthority, List<SysAuthorityResources> sysAuthorityResourcesList) {
		int flag = 0;
		sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority);
		//ѡ�����е�sysAuthorityResources��id
		List<SysAuthorityResources>  all= sysAuthorityResourcesMapper.selectByExample(null);
		if(sysAuthorityResourcesList != null){
			for(SysAuthorityResources r : sysAuthorityResourcesList){
				if(all.contains(r)){
					flag = sysAuthorityResourcesMapper.updateByPrimaryKeySelective(r);				
				}else{
					flag = sysAuthorityResourcesMapper.insertSelective(r);
				}
			}
		}
		return flag != 0?true:false;
	}
	@Override
	public boolean existAuthorityName(String authorityName) {
		
		SysAuthorityExample example = new SysAuthorityExample();
		Criteria c = example.createCriteria();
		c.andAuthorityNameEqualTo(authorityName);
		List<SysAuthority> li = sysAuthorityMapper.selectByExample(example);
		return li.size() == 0;
	}
	@Override
	public void deleteAuthorityDatas(String[] deleteIds) {
		if(deleteIds != null){
			for(String authorityId : deleteIds){
				sysAuthorityMapper.deleteByPrimaryKey(authorityId);
				SysAuthorityResourcesExample example = new SysAuthorityResourcesExample();
				com.hd_business.bean.SysAuthorityResourcesExample.Criteria c = example.createCriteria();
				c.andAuthorityIdEqualTo(authorityId);
				sysAuthorityResourcesMapper.deleteByExample(example);
			}
		}
	}
	@Override
	public List<SysAuthority> getAll() {
		return sysAuthorityMapper.selectByExample(null);
	}
	@Override
	public List<SysAuthority> getSysAuthoritysByRoleId(String roleId) {
		//����roleid �õ� roelauthority
		SysRoleAuthorityExample example = new SysRoleAuthorityExample();
		com.hd_business.bean.SysRoleAuthorityExample.Criteria c = example.createCriteria();
		c.andRoleIdEqualTo(roleId);
		List<SysRoleAuthority> sysRoleAuthorityList= sysRoleAuthorityMapper.selectByExample(example);
		List<String> authorityIds = new ArrayList<>();
		for(SysRoleAuthority s :  sysRoleAuthorityList){
			authorityIds.add(s.getAuthorityId());
		}
		
		List<SysAuthority> sysAuthoritys = new ArrayList<>();
		for(String authorityId:authorityIds){
			SysAuthority s = sysAuthorityMapper.selectByPrimaryKey(authorityId);
			sysAuthoritys.add(s);
		}
		return sysAuthoritys;
	}
	@Override
	public SysRole getRoleByRoleId(String roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}
}
