package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SearchBlogDTO;

public interface BlogService {
	// Blog Module
	
	BlogModel saveBlog(BlogModel model);
	BlogModel getBlogDetailById(Long id);
	List<BlogModel> getBlogDetailListByBlogTypeId(Long id);
	List<BlogModel> getBlogDetailListByUserId(Long userId);
	List<BlogModel> getQueryDetailListWithoutUserId();
	List<BlogModel> searchBlogDetailList(Long id ,String search);
    List<BlogModel> getTopCountBlogDetailList() ;
    List<BlogModel> getBlogTypeCountList() ;
    List<BlogModel> searchBlog(SearchBlogDTO dto);
	
	
}
