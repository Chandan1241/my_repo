package com.chandan.gradle.response;

import java.util.Date;

import com.chandan.gradle.request.UserRequest;

public class UserResponse {

	private Long userId;
	private Date createdDate;
	private Date updateDate;
	private String status;
	private String code;
	private UserRequest request;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserRequest getRequest() {
		return request;
	}

	public void setRequest(UserRequest request) {
		this.request = request;
	}

}
