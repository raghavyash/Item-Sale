package com.raghav.lnt.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.raghav.lnt.entity.QueryAnswerEntity;


public class QueryModel {
	private Long id;
	private String query;
	private Long queryTypeId;
	private String queryTypeName;
	private Long userId;
	private String userName;
	private Integer status;
	private Date createdAt;
	private String createdBy;
	private String description;
	private String comment;
	private String tag;
	private String queryAnswer;
	private Long commentCount;
	private Long answerCount;
	private Set<QueryAnswerModel> queryAnswerModels;
	private Set<QueryCommentModel> queryCommentModels;
	private String reply;
	private String search;
	private Long records;
	private Boolean isVisibleForComment;
	private Boolean isVisibleForAnswer;
	private Boolean isVisibleForCommentReply;
	private Boolean isVisibleForAnswerReply;
	
	
	public Boolean getIsVisibleForCommentReply() {
		return isVisibleForCommentReply;
	}
	public void setIsVisibleForCommentReply(Boolean isVisibleForCommentReply) {
		this.isVisibleForCommentReply = isVisibleForCommentReply;
	}
	public Boolean getIsVisibleForAnswerReply() {
		return isVisibleForAnswerReply;
	}
	public void setIsVisibleForAnswerReply(Boolean isVisibleForAnswerReply) {
		this.isVisibleForAnswerReply = isVisibleForAnswerReply;
	}
	public Boolean getIsVisibleForComment() {
		return isVisibleForComment;
	}
	public void setIsVisibleForComment(Boolean isVisibleForComment) {
		this.isVisibleForComment = isVisibleForComment;
	}
	public Boolean getIsVisibleForAnswer() {
		return isVisibleForAnswer;
	}
	public void setIsVisibleForAnswer(Boolean isVisibleForAnswer) {
		this.isVisibleForAnswer = isVisibleForAnswer;
	}
	public Long getRecords() {
		return records;
	}
	public void setRecords(Long records) {
		this.records = records;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Set<QueryAnswerModel> getQueryAnswerModels() {
		return queryAnswerModels;
	}
	public void setQueryAnswerModels(Set<QueryAnswerModel> queryAnswerModels) {
		this.queryAnswerModels = queryAnswerModels;
	}
	public Set<QueryCommentModel> getQueryCommentModels() {
		return queryCommentModels;
	}
	public void setQueryCommentModels(Set<QueryCommentModel> queryCommentModels) {
		this.queryCommentModels = queryCommentModels;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public Long getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(Long answerCount) {
		this.answerCount = answerCount;
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
	public String getQueryAnswer() {
		return queryAnswer;
	}
	public void setQueryAnswer(String queryAnswer) {
		this.queryAnswer = queryAnswer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
