package com.hd_business.bean;

import java.io.Serializable;
import java.util.Date;

public class SysRoleAuthority implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sysRoleAuthorityId;

    private String roleId;

    private String authorityId;

    private String isDel;

    private Date createTime;

    private Date cTimeStamp;

    public String getSysRoleAuthorityId() {
        return sysRoleAuthorityId;
    }

    public void setSysRoleAuthorityId(String sysRoleAuthorityId) {
        this.sysRoleAuthorityId = sysRoleAuthorityId == null ? null : sysRoleAuthorityId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
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