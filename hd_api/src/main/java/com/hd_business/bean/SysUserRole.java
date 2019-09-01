package com.hd_business.bean;

import java.io.Serializable;
import java.util.Date;

public class SysUserRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sysUserRoleId;

    private String userId;

    private String roleId;

    private String isDel;

    private Date createTime;

    private Date cTimeStamp;

    public String getSysUserRoleId() {
        return sysUserRoleId;
    }

    public void setSysUserRoleId(String sysUserRoleId) {
        this.sysUserRoleId = sysUserRoleId == null ? null : sysUserRoleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getcTimeStamp() {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp) {
        this.cTimeStamp = cTimeStamp;
    }
}