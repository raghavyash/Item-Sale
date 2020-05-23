package com.raghav.lnt.dao;

import java.util.List;

import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.SearchBlogDTO;

public interface BlogServiceDao {
	public List<BlogModel> getTopCountBlogDetailList();
	public List<BlogModel> getBlogTypeCountList() ;
	public List<BlogEntity> searchBlog(SearchBlogDTO dto);
}
