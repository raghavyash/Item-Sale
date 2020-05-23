package com.raghav.lnt.model;

public class SearchQueryDTO {
	private Long queryId;
	private String query;
	private String answer;
	private String search;
	private Long id;
	private Long queryTypeId;
	
	public Long getQueryTypeId() {
		return queryTypeId;
	}
	public void setQueryTypeId(Long queryTypeId) {
		this.queryTypeId = queryTypeId;
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
	public Long getQueryId() {
		return queryId;
	}
	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
