package com.raghav.lnt.model;

import javax.persistence.Column;

public class ItemModel {
	private Long id;
	private String itemName;
	private Long catId;
	private String categoryName;
	private Long subCategoryId;
	private String subCategoryName;
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
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	
}
