package com.raghav.lnt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;

@Entity
@Table(name="query")
public class QueryEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String query;
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "queryTypeId")
	private QueryTypeEntity queryTypeEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	@Column
	private Integer status;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column
	private String createdBy;
	
	@OneToMany(mappedBy = "queryEntity",fetch=FetchType.LAZY)
	private Set<QueryCommentEntity> queryCommentEntities= new HashSet<QueryCommentEntity>();
	
	
	@OneToMany(mappedBy = "queryEntity",fetch=FetchType.LAZY)
	private Set<QueryAnswerEntity> queryAnswerEntities= new HashSet<QueryAnswerEntity>();
	
	public Set<QueryCommentEntity> getQueryCommentEntities() {
		return queryCommentEntities;
	}
	public void setQueryCommentEntities(Set<QueryCommentEntity> queryCommentEntities) {
		this.queryCommentEntities = queryCommentEntities;
	}
	public Set<QueryAnswerEntity> getQueryAnswerEntities() {
		return queryAnswerEntities;
	}
	public void setQueryAnswerEntities(Set<QueryAnswerEntity> queryAnswerEntities) {
		this.queryAnswerEntities = queryAnswerEntities;
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
	public QueryTypeEntity getQueryTypeEntity() {
		return queryTypeEntity;
	}
	public void setQueryTypeEntity(QueryTypeEntity queryTypeEntity) {
		this.queryTypeEntity = queryTypeEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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
