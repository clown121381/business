package com.hd_business.bean;

import java.util.Date;

public class SysRole {
    private String roleId;

    private String roleName;

    private String note;

    private String isDel;

    private Date createTime;

    private Date cTimeStamp;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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