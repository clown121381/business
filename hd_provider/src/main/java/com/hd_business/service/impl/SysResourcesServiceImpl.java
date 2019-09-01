package com.hd_business.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.hd_business.bean.SysAuthorityResources;
import com.hd_business.bean.SysAuthorityResourcesExample;
import com.hd_business.bean.SysResources;
import com.hd_business.bean.SysResourcesExample;
import com.hd_business.bean.SysRoleAuthority;
import com.hd_business.bean.SysRoleAuthorityExample;
import com.hd_business.bean.SysRoleAuthorityExample.Criteria;
import com.hd_business.bean.SysUserRole;
import com.hd_business.bean.SysUserRoleExample;
import com.hd_business.dao.SysAuthorityResourcesMapper;
import com.hd_business.dao.SysResourcesMapper;
import com.hd_business.dao.SysRoleAuthorityMapper;
import com.hd_business.dao.SysUserRoleMapper;
import com.hd_business.service.SysResourcesService;

@Service
@Component
public class SysResourcesServiceImpl implements SysResourcesService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	SysResourcesMapper sysResourcesMapper;
	@Autowired
	SysAuthorityResourcesMapper sysAuthorityResourcesMapper; 
	@Autowired
	SysRoleAuthorityMapper sysRoleAuthorityMapper;
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public List<SysResources> getResourcesByUserId(String userId) {
		
		//�����û�id�õ�һ���ɫid
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		com.hd_business.bean.SysUserRoleExample.Criteria cUserRole = sysUserRoleExample.createCriteria();
		cUserRole.andUserIdEqualTo(userId);
		List<SysUserRole> userRoleList = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		ArrayList<String> roleId = new ArrayList<>();
		if(userRoleList != null && userRoleList.size() > 0){
			for(SysUserRole userRole : userRoleList){
				roleId.add(userRole.getRoleId());
			}
			//����һ���ɫid�õ�һ��Ȩ��id
			SysRoleAuthorityExample roleAuthorityExample = new SysRoleAuthorityExample();
			Criteria cRoleAuthority = roleAuthorityExample.createCriteria();
			cRoleAuthority.andRoleIdIn(roleId);
			List<SysRoleAuthority> roleAuthorityList = sysRoleAuthorityMapper.selectByExample(roleAuthorityExample);
			ArrayList<String> authorityId = new ArrayList<>();
			if(roleAuthorityList!=null && roleAuthorityList.size() > 0){
				for(SysRoleAuthority roleAuthority :roleAuthorityList){
					authorityId.add(roleAuthority.getAuthorityId());
				}
			}else{
				return null;
			}
			
			//����һ��Ȩ��id�õ�һ����Դid
			SysAuthorityResourcesExample authorityResourcesExample = new SysAuthorityResourcesExample();
			com.hd_business.bean.SysAuthorityResourcesExample.Criteria cAuthorityResources = authorityResourcesExample.createCriteria();
			cAuthorityResources.andAuthorityIdIn(authorityId);
			List<SysAuthorityResources> authorityResourcesList = sysAuthorityResourcesMapper.selectByExample(authorityResourcesExample);
			ArrayList<String> resourcesId = new ArrayList<>();
			if(authorityResourcesList!=null && authorityResourcesList.size()>0){
				for(SysAuthorityResources authorityResource:authorityResourcesList){
					resourcesId.add(authorityResource.getResourcesId());
				}
			}else{
				return null;
			}
			
			
			//����һ����Դid�õ���Դ
			SysResourcesExample resourcesExample = new SysResourcesExample();
			com.hd_business.bean.SysResourcesExample.Criteria cResources = resourcesExample.createCriteria();
			cResources.andResourcesIdIn(resourcesId);
			resourcesExample.setOrderByClause("rank");
			List<SysResources> resourcesList = sysResourcesMapper.selectByExample(resourcesExample);
			return resourcesList;
		}else{
			return null;
		}
	}

	@Override
	public List<SysResources> getAll() {
		SysResourcesExample resourcesExample = new SysResourcesExample();
		resourcesExample.setOrderByClause("rank");
		com.hd_business.bean.SysResourcesExample.Criteria c = resourcesExample.createCriteria();
		c.andIsDelEqualTo("N");
		return sysResourcesMapper.selectByExample(resourcesExample);
	}

	@Override
	public boolean addResource(SysResources resource) {
		int flag = sysResourcesMapper.insertSelective(resource);
		if(flag != 0){
			return true;
		}else{
			return false;			
		}
	}

	@Override
	public boolean updateResource(SysResources resources) {
		return sysResourcesMapper.updateByPrimaryKey(resources) != 0? true:false;
	}

	@Override
	public SysResources getResource(String resourcesId) {
		return sysResourcesMapper.selectByPrimaryKey(resourcesId);
	}

	@Override
	public List<SysResources> findByResourcesIds(List<String> strs) {
		if(strs != null){
			SysResourcesExample example = new SysResourcesExample();
			com.hd_business.bean.SysResourcesExample.Criteria c = example.createCriteria();
			c.andResourcesIdIn(strs);
			return sysResourcesMapper.selectByExample(example);			
		}else{
			return null;
		}
	}
	
	
}
