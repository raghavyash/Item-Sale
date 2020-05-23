package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.raghav.lnt.entity.BlogCommentEntity;
import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.BlogReplyCommentEntity;
import com.raghav.lnt.entity.BlogTypeEntity;
import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.BlogReplyCommentModel;
import com.raghav.lnt.model.QueryAnswerModel;

public class BlogMapper {

	public static BlogEntity blogModelToEntity(BlogModel model) {
		BlogEntity entity = new BlogEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getBlogTypeId() != null) {
			BlogTypeEntity blogTypeEntity = new BlogTypeEntity();
			blogTypeEntity.setId(model.getBlogTypeId());
			entity.setBlogTypeEntity(blogTypeEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setDescription(model.getDescription());
		entity.setStatus(1);
		entity.setTitle(model.getTitle());
		entity.setCreatedBy(model.getUserName());

		return entity;
	}

	public static BlogModel blogEntityToModel(BlogEntity entity) {
		BlogModel model = new BlogModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getBlogTypeEntity() != null) {
			model.setBlogTypeId(entity.getBlogTypeEntity().getId());
			model.setBlogTypeName(entity.getBlogTypeEntity().getBlogTypeName());
		}
		if (entity.getBlogCommentEntities() != null) {
			Set<BlogCommentModel> blogCommentList = new HashSet<BlogCommentModel>();
			Set<BlogReplyCommentModel> replyCommentModels=  new HashSet<BlogReplyCommentModel>();
			for (BlogCommentEntity blogCommentEntity : entity.getBlogCommentEntities()) {
				BlogCommentModel blogCommentModel = new BlogCommentModel();
				blogCommentModel.setComment(blogCommentEntity.getComment());
				blogCommentModel.setCreatedAt(blogCommentEntity.getCreatedAt());
				blogCommentModel.setCreatedBy(blogCommentEntity.getCreatedBy());
				blogCommentModel.setId(blogCommentEntity.getId());
				if(blogCommentEntity.getUserEntity()!= null){
					blogCommentModel.setUserName(blogCommentEntity.getUserEntity().getEmail());
				}
				if(blogCommentEntity.getBlogReplyCommentEntities()!= null){
					for(BlogReplyCommentEntity  blogReplyCommentEntity:blogCommentEntity.getBlogReplyCommentEntities()){
						BlogReplyCommentModel blogReplyCommentModel= new BlogReplyCommentModel();
						blogReplyCommentModel.setCreatedAt(blogReplyCommentEntity.getCreatedAt());
						blogReplyCommentModel.setCreatedBy(blogReplyCommentEntity.getCreatedBy());
						blogReplyCommentModel.setBlogCommentId(blogReplyCommentEntity.getBlogCommentEntity().getId());
						blogReplyCommentModel.setId(blogReplyCommentEntity.getId());
						blogReplyCommentModel.setReply(blogReplyCommentEntity.getReply());
						replyCommentModels.add(blogReplyCommentModel);
						
					}
					blogCommentModel.setReplyCommentModels(replyCommentModels);
					blogCommentModel.setReplyCommentCount(Long.valueOf(blogCommentEntity.getBlogReplyCommentEntities().size()));
				}else{
					blogCommentModel.setReplyCommentCount(Long.valueOf(0));
				}
				blogCommentList.add(blogCommentModel);
				model.setCommentCount(Long.valueOf((entity.getBlogCommentEntities().size())));
			}
			model.setBlogCommentModels(blogCommentList);
		}else {
			model.setCommentCount(Long.valueOf(0));
		}
		
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setDescription(entity.getDescription());
		model.setStatus(entity.getStatus());
		model.setId(entity.getId());
		model.setTitle(entity.getTitle());

		return model;
	}
	public static List<BlogModel> blogDetailList(List<BlogEntity> dbList) {
		List<BlogModel> list = new ArrayList<BlogModel>();
		if (dbList != null) {
			for (BlogEntity entity : dbList) {
				BlogModel model = new BlogModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getBlogTypeEntity() != null) {
					model.setBlogTypeId(entity.getBlogTypeEntity().getId());
					model.setBlogTypeName(entity.getBlogTypeEntity().getBlogTypeName());
				}
				if (entity.getBlogCommentEntities() != null) {
					Set<BlogCommentModel> blogCommentList = new HashSet<BlogCommentModel>();
					for (BlogCommentEntity blogCommentEntity : entity.getBlogCommentEntities()) {
						BlogCommentModel blogCommentModel = new BlogCommentModel();
						blogCommentModel.setComment(blogCommentEntity.getComment());
						blogCommentModel.setCreatedAt(blogCommentEntity.getCreatedAt());
						blogCommentModel.setCreatedBy(blogCommentEntity.getCreatedBy());
						blogCommentModel.setId(blogCommentEntity.getId());
						if(blogCommentEntity.getUserEntity()!= null){
							blogCommentModel.setUserName(blogCommentEntity.getUserEntity().getEmail());
						}
						blogCommentList.add(blogCommentModel);
						model.setCommentCount(Long.valueOf((entity.getBlogCommentEntities().size())));
					}
					model.setBlogCommentModels(blogCommentList);
				}else {
					model.setCommentCount(Long.valueOf(0));
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setDescription(entity.getDescription());
				model.setStatus(entity.getStatus());
				model.setId(entity.getId());
				model.setTitle(entity.getTitle());
				list.add(model);
			}
		}
		return list;
	}

}
