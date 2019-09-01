package com.hd_business.dao;

import com.hd_business.bean.SysResources;
import com.hd_business.bean.SysResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourcesMapper {
    long countByExample(SysResourcesExample example);

    int deleteByExample(SysResourcesExample example);

    int deleteByPrimaryKey(String resourcesId);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    List<SysResources> selectByExample(SysResourcesExample example);

    SysResources selectByPrimaryKey(String resourcesId);

    int updateByExampleSelective(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    int updateByExample(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);
}