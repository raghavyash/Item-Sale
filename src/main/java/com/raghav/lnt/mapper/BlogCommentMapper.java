package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.raghav.lnt.entity.BlogCommentEntity;
import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.BlogReplyCommentEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogReplyCommentModel;

public class BlogCommentMapper {
	public static BlogCommentEntity blogCommentModelToEntity(BlogCommentModel model) {
		BlogCommentEntity entity = new BlogCommentEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getBlogId() != null) {
			BlogEntity blogEntity = new BlogEntity();
			blogEntity.setId(model.getBlogId());
			entity.setBlogEntity(blogEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setComment(model.getComment());
		if (model.getTag() != null) {
			entity.setTag(model.getTag());
		}
		entity.setId(model.getId());
		entity.setStatus(1);
		entity.setCreatedBy(model.getUserName());
		return entity;
	}

	public static BlogCommentModel blogCommentEntityToModel(BlogCommentEntity entity) {
		BlogCommentModel model = new BlogCommentModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getBlogEntity() != null) {
			model.setId(entity.getBlogEntity().getId());
			model.setBlogTitle(entity.getBlogEntity().getTitle());
			model.setDescription(entity.getBlogEntity().getDescription());
		}
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setStatus(entity.getStatus());
		model.setTag(entity.getTag());
		return model;
	}

	public static List<BlogCommentModel> blogCommentDetailList(List<BlogCommentEntity> dbList) {
		List<BlogCommentModel> list = new ArrayList<BlogCommentModel>();
		if (dbList != null) {
			for (BlogCommentEntity entity : dbList) {
				BlogCommentModel model = new BlogCommentModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(
							entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getBlogEntity() != null) {
					model.setId(entity.getBlogEntity().getId());
					model.setBlogTitle(entity.getBlogEntity().getTitle());
					model.setDescription(entity.getBlogEntity().getDescription());
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setStatus(entity.getStatus());
				model.setTag(entity.getTag());
				list.add(model);
			}
		}
		return list;
	}
	
	//=================for Bolg Comment Reply Mapper here
	
	public static BlogReplyCommentEntity blogReplyCommentModelToEntity(BlogReplyCommentModel model) {
		BlogReplyCommentEntity entity = new BlogReplyCommentEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getBlogCommentId() != null) {
			BlogCommentEntity blogCommentEntity = new BlogCommentEntity();
			blogCommentEntity.setId(model.getBlogCommentId());
			entity.setBlogCommentEntity(blogCommentEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setReply(model.getReply());
		entity.setId(model.getId());
		entity.setStatus(1);
		entity.setCreatedBy(model.getUserName());
		return entity;
	}
}
