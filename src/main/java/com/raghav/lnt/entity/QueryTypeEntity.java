package com.raghav.lnt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="query_type")
public class QueryTypeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String queryTypeName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQueryTypeName() {
		return queryTypeName;
	}
	public void setQueryTypeName(String queryTypeName) {
		this.queryTypeName = queryTypeName;
	}
	
}
