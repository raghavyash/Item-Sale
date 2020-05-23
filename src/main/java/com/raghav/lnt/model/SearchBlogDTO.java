package com.raghav.lnt.model;

public class SearchBlogDTO {
	private Long blogId;
	private String title;
	private String description;
	private Long id;
	private String search;
	private Long blogTypeId;
	private String name;
	
	public Long getBlogTypeId() {
		return blogTypeId;
	}
	public void setBlogTypeId(Long blogTypeId) {
		this.blogTypeId = blogTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
