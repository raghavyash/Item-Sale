package com.raghav.lnt.model;

import java.util.Date;

public class QueryReplyAnswerModel {
	private Long id;
	private String reply;
	private Long queryAnswerId;
	private String queryAnswer;
	private Long userId;
	private String userName;
	private Integer status;
	private Date createdAt;
	private String createdBy;
	
	public String getQueryAnswer() {
		return queryAnswer;
	}
	public void setQueryAnswer(String queryAnswer) {
		this.queryAnswer = queryAnswer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Long getQueryAnswerId() {
		return queryAnswerId;
	}
	public void setQueryAnswerId(Long queryAnswerId) {
		this.queryAnswerId = queryAnswerId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
