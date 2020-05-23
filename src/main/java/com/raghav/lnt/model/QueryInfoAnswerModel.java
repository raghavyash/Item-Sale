package com.raghav.lnt.model;

import java.math.BigInteger;
import java.util.Date;

public class QueryInfoAnswerModel {
	private Long id;
	private BigInteger views;
	private BigInteger votes;
	private BigInteger comment;
	private Long queryId;
	private String queryName;
	private Long userId;
	private String userName;
	private Integer status;
	private Date createdAt;
	private String createdBy;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigInteger getViews() {
		return views;
	}
	public void setViews(BigInteger views) {
		this.views = views;
	}
	public BigInteger getVotes() {
		return votes;
	}
	public void setVotes(BigInteger votes) {
		this.votes = votes;
	}
	public BigInteger getComment() {
		return comment;
	}
	public void setComment(BigInteger comment) {
		this.comment = comment;
	}
	public Long getQueryId() {
		return queryId;
	}
	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
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
