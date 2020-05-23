package com.raghav.lnt.model;

import java.util.Date;
import java.util.Set;

public class QueryCommentModel {
	private Long id;
	private String comment;
	private String tag;
	private Date createdAt;
	private Long queryId;
	private String queryTitle;
	private String description;
	private Long userId;
	private String userName;
	private String createdBy;
	private Integer status;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getQueryId() {
		return queryId;
	}
	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	public String getQueryTitle() {
		return queryTitle;
	}
	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
