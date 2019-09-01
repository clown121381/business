package com.hd_business.service;

import java.util.List;

import com.hd_business.bean.SysUserInfo;

public interface LoginService {
	public List<SysUserInfo> checkUserInfo(String username,String password);
}
