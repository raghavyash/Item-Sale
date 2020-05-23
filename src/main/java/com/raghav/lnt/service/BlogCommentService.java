package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogReplyCommentModel;

public interface BlogCommentService {
// for Blog Comment 
	
	BlogCommentModel saveBlogComment(BlogCommentModel model);
	BlogCommentModel getBlogCommentDetailById(Long id);
	List<BlogCommentModel> getBlogCommentDetailListByBlogId(Long blogId);
	
	// Blog Comment Reply 
	
	Boolean saveBlogReplyComment(BlogReplyCommentModel model);
}
