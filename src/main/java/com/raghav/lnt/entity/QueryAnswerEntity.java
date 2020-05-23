package com.raghav.lnt.entity;

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
@Table(name="query_answer")
public class QueryAnswerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String queryAnswer;
	
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
	
	@OneToMany(mappedBy = "queryAnswerEntity",fetch=FetchType.LAZY)
	private Set<QueryReplyAnswerEntity> queryReplyAnswerEntities= new HashSet<QueryReplyAnswerEntity>();
	
	public Set<QueryReplyAnswerEntity> getQueryReplyAnswerEntities() {
		return queryReplyAnswerEntities;
	}
	public void setQueryReplyAnswerEntities(Set<QueryReplyAnswerEntity> queryReplyAnswerEntities) {
		this.queryReplyAnswerEntities = queryReplyAnswerEntities;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQueryAnswer() {
		return queryAnswer;
	}
	public void setQueryAnswer(String queryAnswer) {
		this.queryAnswer = queryAnswer;
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
