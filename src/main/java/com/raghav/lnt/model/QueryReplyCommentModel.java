package com.raghav.lnt.model;

import java.util.Date;
import java.util.Set;

public class QueryReplyCommentModel {
	private Long id;
	private String reply;
	private Long queryCommentId;
	private String queryComment;
	private Long userId;
	private String userName;
	private Integer status;
	private Date createdAt;
	private String createdBy;
    private Set<QueryReplyCommentModel> replyCommentModels;
	
	
	public Set<QueryReplyCommentModel> getReplyCommentModels() {
		return replyCommentModels;
	}
	public void setReplyCommentModels(Set<QueryReplyCommentModel> replyCommentModels) {
		this.replyCommentModels = replyCommentModels;
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
	public Long getQueryCommentId() {
		return queryCommentId;
	}
	public void setQueryCommentId(Long queryCommentId) {
		this.queryCommentId = queryCommentId;
	}
	
	public String getQueryComment() {
		return queryComment;
	}
	public void setQueryComment(String queryComment) {
		this.queryComment = queryComment;
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
