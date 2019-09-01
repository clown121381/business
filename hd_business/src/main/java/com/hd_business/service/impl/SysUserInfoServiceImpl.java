package com.hd_business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.common.page.PageCondition;
import com.hd.common.page.PageModel;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.bean.SysUserInfoExample;
import com.hd_business.bean.SysUserRole;
import com.hd_business.bean.SysUserRoleExample;
import com.hd_business.bean.SysUserRoleExample.Criteria;
import com.hd_business.dao.SysUserInfoMapper;
import com.hd_business.dao.SysUserRoleMapper;
import com.hd_business.service.SysUserInfoService;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService{

	
	@Autowired
	SysUserInfoMapper sysUserInfoMapper;
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	@Override
	public PageModel<SysUserInfo> findUsersPage(String userName, PageCondition condition) {
		PageModel<SysUserInfo> pm = new PageModel<SysUserInfo>();		
		List<SysUserInfo> rows = sysUserInfoMapper.selectByPages(userName, condition.getPageIndex()-1<0?0:condition.getPageIndex()-1, condition.getPageSize());
		pm.setRows(rows);
		pm.setPageSize(condition.getPageSize());
		pm.setPageIndex(condition.getIndex());
		SysUserInfoExample example = new SysUserInfoExample();
		if(userName != null && userName != ""){
			com.hd_business.bean.SysUserInfoExample.Criteria c = example.createCriteria();
			c.andUserNameLike(userName);			
		}
		int total = (int)sysUserInfoMapper.countByExample(example);
		pm.setTotal(total);
		return pm;
	}
	@Override
	public boolean existUserName(String userName) {
		
		List<SysUserInfo> list = sysUserInfoMapper.selectByExample(null);
		for(SysUserInfo l : list){
			if(userName.equals(l.getUserName())){
				return true;
			}
		}
		return false;
	}
	@Override
	public List<SysUserRole> getRoleByUserId(String userId) {
		SysUserRoleExample example = new SysUserRoleExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		return sysUserRoleMapper.selectByExample(example);
	}
	@Override
	public SysUserInfo getUserInfoByUserId(String userId) {
		return sysUserInfoMapper.selectByPrimaryKey(userId);
	}
	@Override
	public void add(SysUserInfo user, List<SysUserRole> list) {
		sysUserInfoMapper.insertSelective(user);
		if(list!=null){
			for(SysUserRole r : list){
				sysUserRoleMapper.insertSelective(r);
			}			
		}
	}
	@Override
	public SysUserInfo getUserByUserId(String userId) {
		return sysUserInfoMapper.selectByPrimaryKey(userId);
	}
	@Override
	public void update(SysUserInfo oldUser, List<SysUserRole> list) {
		sysUserInfoMapper.updateByPrimaryKeySelective(oldUser);
		SysUserRoleExample example = new SysUserRoleExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(oldUser.getUserId());
		sysUserRoleMapper.deleteByExample(example);
		if(list!=null){
			for(SysUserRole r : list){
				sysUserRoleMapper.insertSelective(r);
			}
		}
	}
	@Override
	public void deleteUserRole(List<String> ids) {
		SysUserInfoExample example = new SysUserInfoExample();
		com.hd_business.bean.SysUserInfoExample.Criteria c = example.createCriteria();
		c.andUserIdIn(ids);
		sysUserInfoMapper.deleteByExample(example);
		
		SysUserRoleExample roleExample = new SysUserRoleExample();
		Criteria roleC = roleExample.createCriteria();
		roleC.andUserIdIn(ids);
		sysUserRoleMapper.deleteByExample(roleExample);
	}

}
