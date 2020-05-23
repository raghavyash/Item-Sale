package com.raghav.lnt.model;

import java.util.Date;
import java.util.Set;

public class BlogModel {
	private Long id;
	private String title;
	private String description;
	private Date createdAt;
	private String createdBy;
	private Long blogTypeId;
	private String blogTypeName;
	private Long userId;
	private String userName;
	private Integer status;
	private String comment;
	private Long commentCount;
	private String search;
	private Set<BlogCommentModel> blogCommentModels;
	private Long records;
	private Boolean isVisibleForComment;
	private Boolean isVisibleForCommentReply;

	

	public Boolean getIsVisibleForCommentReply() {
		return isVisibleForCommentReply;
	}

	public void setIsVisibleForCommentReply(Boolean isVisibleForCommentReply) {
		this.isVisibleForCommentReply = isVisibleForCommentReply;
	}

	public Boolean getIsVisibleForComment() {
		return isVisibleForComment;
	}

	public void setIsVisibleForComment(Boolean isVisibleForComment) {
		this.isVisibleForComment = isVisibleForComment;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
	}

	public Set<BlogCommentModel> getBlogCommentModels() {
		return blogCommentModels;
	}

	public void setBlogCommentModels(Set<BlogCommentModel> blogCommentModels) {
		this.blogCommentModels = blogCommentModels;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getBlogTypeId() {
		return blogTypeId;
	}

	public void setBlogTypeId(Long blogTypeId) {
		this.blogTypeId = blogTypeId;
	}

	public String getBlogTypeName() {
		return blogTypeName;
	}

	public void setBlogTypeName(String blogTypeName) {
		this.blogTypeName = blogTypeName;
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
}
