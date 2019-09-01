package com.hd_business.dao;

import com.hd_business.bean.SysAuthority;
import com.hd_business.bean.SysUserInfo;
import com.hd_business.bean.SysUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserInfoMapper {
    long countByExample(SysUserInfoExample example);

    int deleteByExample(SysUserInfoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    List<SysUserInfo> selectByExample(SysUserInfoExample example);

    SysUserInfo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysUserInfo record, @Param("example") SysUserInfoExample example);

    int updateByExample(@Param("record") SysUserInfo record, @Param("example") SysUserInfoExample example);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

	List<SysUserInfo> selectByPages(@Param("userName") String userName,@Param("start") int start,@Param("pageSize") int pageSize);
}