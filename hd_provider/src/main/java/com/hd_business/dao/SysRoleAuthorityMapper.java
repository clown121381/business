package com.hd_business.dao;

import com.hd_business.bean.SysRoleAuthority;
import com.hd_business.bean.SysRoleAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAuthorityMapper {
    long countByExample(SysRoleAuthorityExample example);

    int deleteByExample(SysRoleAuthorityExample example);

    int deleteByPrimaryKey(String sysRoleAuthorityId);

    int insert(SysRoleAuthority record);

    int insertSelective(SysRoleAuthority record);

    List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample example);

    SysRoleAuthority selectByPrimaryKey(String sysRoleAuthorityId);

    int updateByExampleSelective(@Param("record") SysRoleAuthority record, @Param("example") SysRoleAuthorityExample example);

    int updateByExample(@Param("record") SysRoleAuthority record, @Param("example") SysRoleAuthorityExample example);

    int updateByPrimaryKeySelective(SysRoleAuthority record);

    int updateByPrimaryKey(SysRoleAuthority record);
}