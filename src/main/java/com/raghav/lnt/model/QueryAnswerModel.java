package com.raghav.lnt.model;

import java.util.Date;
import java.util.Set;

public class QueryAnswerModel {
	private Long id;
	private String query;
	private String queryAnswer;
	private Long queryId;
	private Long queryTypeId;
	private String queryTypeName;
	private Long userId;
	private String userName;
	private Integer status;
	private Date createdAt;
	private String createdBy;
	private Set<QueryReplyAnswerModel> replyAnswerModels;
	
	public Set<QueryReplyAnswerModel> getReplyAnswerModels() {
		return replyAnswerModels;
	}
	public void setReplyAnswerModels(Set<QueryReplyAnswerModel> replyAnswerModels) {
		this.replyAnswerModels = replyAnswerModels;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQueryAnswer() {
		return queryAnswer;
	}
	public void setQueryAnswer(String queryAnswer) {
		this.queryAnswer = queryAnswer;
	}
	public Long getQueryId() {
		return queryId;
	}
	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	public Long getQueryTypeId() {
		return queryTypeId;
	}
	public void setQueryTypeId(Long queryTypeId) {
		this.queryTypeId = queryTypeId;
	}
	public String getQueryTypeName() {
		return queryTypeName;
	}
	public void setQueryTypeName(String queryTypeName) {
		this.queryTypeName = queryTypeName;
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
