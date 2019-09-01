package com.hd_business.service;

import java.util.List;

import com.hd_business.bean.SysResources;

public interface SysResourcesService {
	List<SysResources> getResourcesByUserId(String userId);
	List<SysResources> getAll();
	boolean addResource(SysResources resource);
	boolean updateResource(SysResources resources);
	SysResources getResource(String resourcesId);
	List<SysResources> findByResourcesIds(List<String> strs);
}
