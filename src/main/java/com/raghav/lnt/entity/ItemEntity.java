package com.raghav.lnt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String itemName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subCategoryId")
    private SubCategoryEntity subCategoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
    private CategoryEntity categoryId;
	
	@Column
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public SubCategoryEntity getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryEntity subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public CategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
