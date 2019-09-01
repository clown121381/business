package com.hd_business.dao;

import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthorityMapper {
    long countByExample(SysAuthorityExample example);

    int deleteByExample(SysAuthorityExample example);

    int deleteByPrimaryKey(String authorityId);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    List<SysAuthority> selectByExample(SysAuthorityExample example);

    SysAuthority selectByPrimaryKey(String authorityId);

    int updateByExampleSelective(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByExample(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
    
    List<SysAuthority> selectByPages(@Param("authoritySearchName") String authoritySearchName,@Param("start") int start,@Param("total") int total);
}