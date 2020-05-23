package com.raghav.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghav.lnt.entity.BlogCommentEntity;
import com.raghav.lnt.entity.BlogReplyCommentEntity;
import com.raghav.lnt.mapper.BlogCommentMapper;
import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogReplyCommentModel;
import com.raghav.lnt.repository.BlogCommentRepository;
import com.raghav.lnt.repository.BlogReplyCommentRepository;
@Service
public class BlogCommentServiceImpl implements BlogCommentService {
	@Autowired
	BlogCommentRepository blogCommentRepository;
	@Autowired
	BlogReplyCommentRepository blogReplyCommentRepository;
	
	public BlogCommentModel saveBlogComment(BlogCommentModel model) {
		BlogCommentModel result = null;
		BlogCommentEntity entity = BlogCommentMapper.blogCommentModelToEntity(model);
		BlogCommentEntity entity2 = blogCommentRepository.save(entity);
		if (entity2 != null) {
			result = BlogCommentMapper.blogCommentEntityToModel(entity2);
		}
		return result;
	}

	public BlogCommentModel getBlogCommentDetailById(Long id) {
		BlogCommentModel model = null;
		BlogCommentEntity entity = blogCommentRepository.getOne(id);
		if (entity != null) {
			model = BlogCommentMapper.blogCommentEntityToModel(entity);
		}
		return model;
	}

	public List<BlogCommentModel> getBlogCommentDetailListByBlogId(Long blogId) {
		List<BlogCommentModel> list = null;
		List<BlogCommentEntity> dbList = blogCommentRepository.findBlogCommentByBlogId(blogId);
		if (dbList != null) {
			list = BlogCommentMapper.blogCommentDetailList(dbList);
		}
		return list;
	}
	//==Blog Reply Comment Module============================================
	public Boolean saveBlogReplyComment(BlogReplyCommentModel model){
		Boolean result = false;
		BlogReplyCommentEntity entity = BlogCommentMapper.blogReplyCommentModelToEntity(model);
		BlogReplyCommentEntity entity2 = blogReplyCommentRepository.save(entity);
		if (entity2 != null) {
			result = true;
		}
		return result;
	}
}
