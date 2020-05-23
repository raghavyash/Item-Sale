package com.raghav.lnt.model;

import java.util.Date;
import java.util.Set;


public class BlogCommentModel {
	private Long id;
	private String comment;
	private String tag;
	private Date createdAt;
	private Long blogId;
	private String blogTitle;
	private String description;
	private Long userId;
	private String userName;
	private String createdBy;
	private Integer status;
	private Set<BlogReplyCommentModel> replyCommentModels;
	private Long replyCommentCount;
	
	public Long getReplyCommentCount() {
		return replyCommentCount;
	}
	public void setReplyCommentCount(Long replyCommentCount) {
		this.replyCommentCount = replyCommentCount;
	}
	public Set<BlogReplyCommentModel> getReplyCommentModels() {
		return replyCommentModels;
	}
	public void setReplyCommentModels(Set<BlogReplyCommentModel> replyCommentModels) {
		this.replyCommentModels = replyCommentModels;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
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
	
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
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
