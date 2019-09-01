package com.hd.entity.business.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 鎻忚堪锛氭潈闄愭爲<br>
 * 浣滆�咃細 <br>
 * 淇敼鏃ユ湡锛�2016骞�9鏈�9鏃ヤ笅鍗�4:35:02 <br>
 * E-mail:  <br>
 */
public class ResourcesTree implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ResourcesTree [id=" + id + ", text=" + text + ", state=" + state + ", isLeaf=" + isLeaf + ", iconCls="
				+ iconCls + ", checked=" + checked + ", parentId=" + parentId + ", resourcesId=" + resourcesId
				+ ", resourcesName=" + resourcesName + ", resourcesType=" + resourcesType + ", resourcesParent="
				+ resourcesParent + ", resourcesLink=" + resourcesLink + ", resourcesNote=" + resourcesNote
				+ ", resourcesCode=" + resourcesCode + ", isDel=" + isDel + ", rank=" + rank + ", createTime="
				+ createTime + ", cTimeStamp=" + cTimeStamp + ", attributes=" + attributes + "]";
	}

	private String id;
	private String text;
	private String state;
	/**鏄惁鏄彾瀛愮粨鐐�*/
	private String isLeaf; 
	/**鍥炬爣*/
	private String iconCls;
	
	private boolean checked = false;
	
	private String parentId;
	
	//涓婚敭ID
	private String resourcesId;
	//璧勬簮鍚嶇О
	private String resourcesName;
	//璧勬簮绫诲瀷 M鐩綍 鎴朏鍔熻兘
	private String resourcesType;
	//鐖剁骇璧勬簮缂栧彿
	private String resourcesParent;
	//璧勬簮閾炬帴
	private String resourcesLink;
	//璧勬簮鎻忚堪
	private String resourcesNote;
	//璧勬簮缂栧彿
	private String resourcesCode;
	//鏄惁鍒犻櫎锛孻-宸插垹闄わ紝N-鏈垹闄�
	private String isDel;
	//璧勬簮搴忓彿
	private String rank;
	//鍒涘缓鏃堕棿
	private Date createTime;
	//鏈�鍚庝竴娆′慨鏀规椂闂�
	private Date cTimeStamp;
	
	
	
	
	
	private Object attributes;
	public static class Attribute{
		private String url;
		private String level;
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}
		
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public Object getAttributes() {
		return attributes;
	}
	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}
	public String getResourcesName() {
		return resourcesName;
	}
	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}
	public String getResourcesType() {
		return resourcesType;
	}
	public void setResourcesType(String resourcesType) {
		this.resourcesType = resourcesType;
	}
	public String getResourcesParent() {
		return resourcesParent;
	}
	public void setResourcesParent(String resourcesParent) {
		this.resourcesParent = resourcesParent;
	}
	public String getResourcesLink() {
		return resourcesLink;
	}
	public void setResourcesLink(String resourcesLink) {
		this.resourcesLink = resourcesLink;
	}
	public String getResourcesNote() {
		return resourcesNote;
	}
	public void setResourcesNote(String resourcesNote) {
		this.resourcesNote = resourcesNote;
	}
	public String getResourcesCode() {
		return resourcesCode;
	}
	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
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
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
