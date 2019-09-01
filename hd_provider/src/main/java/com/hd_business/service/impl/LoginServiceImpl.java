package com.hd_business.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.bean.SysUserInfoExample;
import com.hd_business.bean.SysUserInfoExample.Criteria;
import com.hd_business.dao.SysUserInfoMapper;
import com.hd_business.service.LoginService;

@Service
@Component
public class LoginServiceImpl implements LoginService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;
	
	@Override
	public List<SysUserInfo> checkUserInfo(String username, String password) {
		SysUserInfoExample sysUserInfoExample = new SysUserInfoExample();
		Criteria criteria = sysUserInfoExample.createCriteria();
		criteria.andUserNameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		criteria.andIsDelEqualTo("N");
		List<SysUserInfo> userList = sysUserInfoMapper.selectByExample(sysUserInfoExample);
		return userList;
	}

}
