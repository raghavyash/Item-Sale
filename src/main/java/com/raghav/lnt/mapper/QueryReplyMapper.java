package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.QueryCommentEntity;
import com.raghav.lnt.entity.QueryReplyAnswerEntity;
import com.raghav.lnt.entity.QueryReplyCommentEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.model.QueryReplyCommentModel;

public class QueryReplyMapper {
	public static QueryReplyAnswerEntity queryAnswerReplyModelToEntity(QueryReplyAnswerModel model) {
		QueryReplyAnswerEntity entity = new QueryReplyAnswerEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getQueryAnswerId() != null) {
			QueryAnswerEntity queryEntity = new QueryAnswerEntity();
			queryEntity.setId(model.getQueryAnswerId());
			entity.setQueryAnswerEntity(queryEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setReply(model.getReply());
		entity.setCreatedBy(model.getUserName());
		entity.setStatus(1);
		return entity;
	}
	public static QueryReplyAnswerModel queryAnswerReplyEntityToModel(QueryReplyAnswerEntity entity) {
		QueryReplyAnswerModel model = new QueryReplyAnswerModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getQueryAnswerEntity() != null) {
			model.setQueryAnswerId(entity.getQueryAnswerEntity().getId());
			model.setQueryAnswer(entity.getQueryAnswerEntity().getQueryAnswer());
		}
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setReply(entity.getReply());
		model.setId(entity.getId());
		return model;
	}
	public static List<QueryReplyAnswerModel> queryAnswerReplyDetailList(List<QueryReplyAnswerEntity> dbList) {
		List<QueryReplyAnswerModel> list = new ArrayList<QueryReplyAnswerModel>();
		if (dbList != null) {
			for (QueryReplyAnswerEntity entity : dbList) {
				QueryReplyAnswerModel model = new QueryReplyAnswerModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getQueryAnswerEntity() != null) {
					model.setQueryAnswerId(entity.getQueryAnswerEntity().getId());
					model.setQueryAnswer(entity.getQueryAnswerEntity().getQueryAnswer());
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setId(entity.getId());
				model.setReply(entity.getReply());
				list.add(model);
			}
		}
		return list;
	}
	//==================== For Query Comment Reply 
	public static QueryReplyCommentEntity queryCommentReplyModelToEntity(QueryReplyCommentModel model) {
		QueryReplyCommentEntity entity = new QueryReplyCommentEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getQueryCommentId() != null) {
			QueryCommentEntity queryEntity = new QueryCommentEntity();
			queryEntity.setId(model.getQueryCommentId());
			entity.setQueryCommentEntity(queryEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setReply(model.getReply());
		entity.setCreatedBy(model.getUserName());
		entity.setStatus(1);
		return entity;
	}
	
	public static QueryReplyCommentModel queryCommentReplyEntityToModel(QueryReplyCommentEntity entity) {
		QueryReplyCommentModel model = new QueryReplyCommentModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getQueryCommentEntity() != null) {
			model.setQueryCommentId(entity.getQueryCommentEntity().getId());
			model.setQueryComment(entity.getQueryCommentEntity().getComment());
		}
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setReply(entity.getReply());
		model.setId(entity.getId());
		return model;
	}
	public static List<QueryReplyCommentModel> queryCommentReplyDetailList(List<QueryReplyCommentEntity> dbList) {
		List<QueryReplyCommentModel> list = new ArrayList<QueryReplyCommentModel>();
		if (dbList != null) {
			for (QueryReplyCommentEntity entity : dbList) {
				QueryReplyCommentModel model = new QueryReplyCommentModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getQueryCommentEntity() != null) {
					model.setQueryCommentId(entity.getQueryCommentEntity().getId());
					model.setQueryComment(entity.getQueryCommentEntity().getComment());
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setId(entity.getId());
				model.setReply(entity.getReply());
				list.add(model);
			}
		}
		return list;
	}
}
