package com.hd.entity.business.user;

import java.util.Date;
import java.util.List;

/**
 * 描述：权限树<br>
 * 修改日期：2016年9月9日下午4:35:02 <br>
 * E-mail:  <br>
 */
public class UserInfoData {
	
	private String total;

	public List<UserDataRow> rows;
	
	public static class UserDataRow {
	   //用户电子邮箱，由数字、字母、下划线、@组成
	   private String userId;
	   //用户类型,超级管理员或普通管理员
	   private String userType;
	   //用户邮箱
	   private String email;
	   //姓名
	   private String userName;
	   //是否删除，Y-未冻结，N-已冻结
	   private String status;
	   //创建时间
	   private Date createTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public List<UserDataRow> getRows() {
		return rows;
	}
	public void setRows(List<UserDataRow> rows) {
		this.rows = rows;
	}
}
