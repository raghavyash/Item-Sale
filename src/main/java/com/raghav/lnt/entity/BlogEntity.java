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
@Table(name="blog")
public class BlogEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blogTypeId")
	private BlogTypeEntity blogTypeEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	@Column
	private Integer status;
	@Column
	private String createdBy;
	
	@OneToMany(mappedBy = "blogEntity",fetch=FetchType.LAZY)
	private Set<BlogCommentEntity> blogCommentEntities= new HashSet<BlogCommentEntity>();
	
	
	public Set<BlogCommentEntity> getBlogCommentEntities() {
		return blogCommentEntities;
	}
	public void setBlogCommentEntities(Set<BlogCommentEntity> blogCommentEntities) {
		this.blogCommentEntities = blogCommentEntities;
	}
	public BlogTypeEntity getBlogTypeEntity() {
		return blogTypeEntity;
	}
	public void setBlogTypeEntity(BlogTypeEntity blogTypeEntity) {
		this.blogTypeEntity = blogTypeEntity;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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
