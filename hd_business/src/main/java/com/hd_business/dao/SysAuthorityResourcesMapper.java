package com.hd_business.dao;

import com.hd_business.bean.SysAuthorityResources;
import com.hd_business.bean.SysAuthorityResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthorityResourcesMapper {
    long countByExample(SysAuthorityResourcesExample example);

    int deleteByExample(SysAuthorityResourcesExample example);

    int deleteByPrimaryKey(String sysRoleAuthorityId);

    int insert(SysAuthorityResources record);

    int insertSelective(SysAuthorityResources record);

    List<SysAuthorityResources> selectByExample(SysAuthorityResourcesExample example);

    SysAuthorityResources selectByPrimaryKey(String sysRoleAuthorityId);

    int updateByExampleSelective(@Param("record") SysAuthorityResources record, @Param("example") SysAuthorityResourcesExample example);

    int updateByExample(@Param("record") SysAuthorityResources record, @Param("example") SysAuthorityResourcesExample example);

    int updateByPrimaryKeySelective(SysAuthorityResources record);

    int updateByPrimaryKey(SysAuthorityResources record);
}