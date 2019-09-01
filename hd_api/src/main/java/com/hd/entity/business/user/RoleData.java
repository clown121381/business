package com.hd.entity.business.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述：权限树<br>
 * 作者： <br>
 * 修改日期：2016年9月9日下午4:35:02 <br>
 * E-mail: <br>
 */
public class RoleData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String total;

	public List<RoleDataRow> rows;

	public static class RoleDataRow {

		// 角色编号，唯一，通过UUID产生
		private String roleId;
		// 角色名称
		private String roleName;
		// 备注
		private String note;
		// 创建时间
		private Date createTime;

		public String getRoleId() {
			return roleId;
		}

		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
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

	public List<RoleDataRow> getRows() {
		return rows;
	}

	public void setRows(List<RoleDataRow> rows) {
		this.rows = rows;
	}
}
