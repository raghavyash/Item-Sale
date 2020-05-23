package com.raghav.lnt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="query_comment")
public class QueryCommentEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String comment;
	@Column
	private String tag;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "queryId")
	private QueryEntity queryEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	
	@Column
	private String url;
	@Column
	private Integer status;
	
	@OneToMany(mappedBy = "queryCommentEntity",fetch=FetchType.LAZY)
	private Set<QueryReplyCommentEntity> queryReplyCommentEntities= new HashSet<QueryReplyCommentEntity>();
	
	public Set<QueryReplyCommentEntity> getQueryReplyCommentEntities() {
		return queryReplyCommentEntities;
	}
	public void setQueryReplyCommentEntities(Set<QueryReplyCommentEntity> queryReplyCommentEntities) {
		this.queryReplyCommentEntities = queryReplyCommentEntities;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
