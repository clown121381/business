package com.hd.entity.business.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述：权限树<br>
 * 作者： <br>
 * 修改日期：2016年9月9日下午4:35:02 <br>
 * E-mail:  <br>
 */
public class AuthorityData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String total;

	public List<AuthorityDataRow> rows;
	
	public static class AuthorityDataRow {
	   //权限ID
	   private String authorityId;
	   //权限名称
	   private String authorityName;
	   //备注，对于创建和编辑，链接中保存的是展示页面的链接，备注中保存的是功能的链接
	   private String note;
	   //创建时间
	   private Date createTime;
		   
		public String getAuthorityId() {
			return authorityId;
		}
		public void setAuthorityId(String authorityId) {
			this.authorityId = authorityId;
		}
		public String getAuthorityName() {
			return authorityName;
		}
		public void setAuthorityName(String authorityName) {
			this.authorityName = authorityName;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<AuthorityDataRow> getRows() {
		return rows;
	}
	public void setRows(List<AuthorityDataRow> rows) {
		this.rows = rows;
	}
}
