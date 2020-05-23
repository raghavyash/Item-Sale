package com.raghav.lnt.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="query_info_answer")
public class QueryInfoAnswerEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private Long views;
	@Column
	private Long likes;
	@Column
	private Long votes;
	@Column
	private Long comments;
	@Column
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "queryId")
	private QueryEntity queryEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column
	private String createdBy;
	
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
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
	
	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}
	public Long getVotes() {
		return votes;
	}
	public void setVotes(Long votes) {
		this.votes = votes;
	}
	public Long getComments() {
		return comments;
	}
	public void setComments(Long comments) {
		this.comments = comments;
	}
	public QueryEntity getQueryEntity() {
		return queryEntity;
	}
	public void setQueryEntity(QueryEntity queryEntity) {
		this.queryEntity = queryEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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
