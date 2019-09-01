package com.hd_business.bean;

import java.io.Serializable;
import java.util.Date;

public class SysAuthority implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authorityId;

    private String authorityName;

    private String note;

    private String isDel;

    private Date createTime;

    @Override
	public String toString() {
		return "SysAuthority [authorityId=" + authorityId + ", authorityName=" + authorityName + ", note=" + note
				+ ", isDel=" + isDel + ", createTime=" + createTime + ", cTimeStamp=" + cTimeStamp + "]";
	}

	private Date cTimeStamp;

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId == null ? null : authorityId.trim();
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
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