package com.hd_business.bean;

import java.util.Date;

public class SysResources {
    private String resourcesId;

    private String resourcesName;

    private String resourcesType;

    private String resourcesParent;

    private String resourcesLink;

    private String resourcesNote;

    private String resourcesCode;

    private String isDel;

    private String rank;

    private Date createTime;

    private Date cTimeStamp;

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId == null ? null : resourcesId.trim();
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName == null ? null : resourcesName.trim();
    }

    public String getResourcesType() {
        return resourcesType;
    }

    public void setResourcesType(String resourcesType) {
        this.resourcesType = resourcesType == null ? null : resourcesType.trim();
    }

    public String getResourcesParent() {
        return resourcesParent;
    }

    public void setResourcesParent(String resourcesParent) {
        this.resourcesParent = resourcesParent == null ? null : resourcesParent.trim();
    }

    public String getResourcesLink() {
        return resourcesLink;
    }

    public void setResourcesLink(String resourcesLink) {
        this.resourcesLink = resourcesLink == null ? null : resourcesLink.trim();
    }

    public String getResourcesNote() {
        return resourcesNote;
    }

    public void setResourcesNote(String resourcesNote) {
        this.resourcesNote = resourcesNote == null ? null : resourcesNote.trim();
    }

    public String getResourcesCode() {
        return resourcesCode;
    }

    public void setResourcesCode(String resourcesCode) {
        this.resourcesCode = resourcesCode == null ? null : resourcesCode.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
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