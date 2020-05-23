package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.raghav.lnt.entity.QueryCommentEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.QueryCommentModel;

public class QueryCommentMapper {
	public static QueryCommentEntity queryCommentModelToEntity(QueryCommentModel model) {
		QueryCommentEntity entity = new QueryCommentEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getQueryId() != null) {
			QueryEntity queryEntity = new QueryEntity();
			queryEntity.setId(model.getQueryId());
			entity.setQueryEntity(queryEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setComment(model.getComment());
		if (model.getTag() != null) {
			entity.setTag(model.getTag());
		}
		entity.setStatus(1);
		entity.setCreatedBy(model.getUserName());
		return entity;
	}

	public static QueryCommentModel queryCommentEntityToModel(QueryCommentEntity entity) {
		QueryCommentModel model = new QueryCommentModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getQueryEntity() != null) {
			model.setId(entity.getQueryEntity().getId());
			model.setQueryTitle(entity.getQueryEntity().getQuery());
			model.setDescription(entity.getQueryEntity().getDescription());
		}
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setStatus(entity.getStatus());
		model.setTag(entity.getTag());
		return model;
	}
	
	public static List<QueryCommentModel> queryCommentDetailList(List<QueryCommentEntity> dbList) {
		List<QueryCommentModel> list = new ArrayList<QueryCommentModel>();
		if (dbList != null) {
			for (QueryCommentEntity entity : dbList) {
				QueryCommentModel model = new QueryCommentModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(
							entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getQueryEntity() != null) {
					model.setId(entity.getQueryEntity().getId());
					model.setQueryTitle((entity.getQueryEntity().getQuery()));
					model.setDescription(entity.getQueryEntity().getDescription());
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

}
