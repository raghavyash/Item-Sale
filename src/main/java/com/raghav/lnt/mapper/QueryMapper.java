package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.QueryCommentEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.QueryReplyAnswerEntity;
import com.raghav.lnt.entity.QueryReplyCommentEntity;
import com.raghav.lnt.entity.QueryTypeEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.model.QueryReplyCommentModel;

public class QueryMapper {
	public static QueryEntity queryModelToEntity(QueryModel model) {
		QueryEntity entity = new QueryEntity();

		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		if (model.getQueryTypeId() != null) {
			QueryTypeEntity queryTypeEntity = new QueryTypeEntity();
			queryTypeEntity.setId(model.getQueryTypeId());
			entity.setQueryTypeEntity(queryTypeEntity);
		}
		entity.setCreatedAt(new Date());
		entity.setQuery(model.getQuery());
		entity.setDescription(model.getDescription());
		entity.setStatus(1);
		entity.setCreatedBy(model.getUserName());

		return entity;
	}

	public static QueryModel queryEntityToModel(QueryEntity entity) {
		QueryModel model = new QueryModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getQueryTypeEntity() != null) {
			model.setQueryTypeId(entity.getQueryTypeEntity().getId());
			model.setQueryTypeName(entity.getQueryTypeEntity().getQueryTypeName());
		}
		if (entity.getQueryCommentEntities() != null) {
			Set<QueryCommentModel> queryCommentModels = new HashSet<QueryCommentModel>();
			Set<QueryReplyCommentModel> queryReplyCommentModels = new HashSet<QueryReplyCommentModel>();
			for (QueryCommentEntity commentEntity : entity.getQueryCommentEntities()) {
				QueryCommentModel commentModel = new QueryCommentModel();
				commentModel.setComment(commentEntity.getComment());
				commentModel.setCreatedAt(commentEntity.getCreatedAt());
				commentModel.setCreatedBy(commentEntity.getCreatedBy());
				commentModel.setId(commentEntity.getId());
				
               // for Query Reply Comment List add in Answer List
				if (commentEntity.getQueryReplyCommentEntities() != null) {
					for (QueryReplyCommentEntity queryReplyCommentEntity : commentEntity
							.getQueryReplyCommentEntities()) {
						QueryReplyCommentModel queryReplyCommentModel = new QueryReplyCommentModel();
						queryReplyCommentModel.setCreatedAt(queryReplyCommentEntity.getCreatedAt());
						queryReplyCommentModel.setCreatedBy(queryReplyCommentEntity.getCreatedBy());
						queryReplyCommentModel.setId(queryReplyCommentEntity.getId());
						queryReplyCommentModel.setReply(queryReplyCommentEntity.getReply());
						queryReplyCommentModel
								.setQueryCommentId(queryReplyCommentEntity.getQueryCommentEntity().getId());
						queryReplyCommentModels.add(queryReplyCommentModel);
					}
					commentModel.setReplyCommentModels(queryReplyCommentModels);
				}// end if Query Reply Comment List 
				
				queryCommentModels.add(commentModel);
			}
		
			model.setQueryCommentModels(queryCommentModels);
			model.setCommentCount(Long.valueOf((entity.getQueryCommentEntities().size())));
		} else {
			model.setCommentCount(Long.valueOf(0));
		}
		if (entity.getQueryAnswerEntities() != null) {
			Set<QueryAnswerModel> queryAnswerModels = new HashSet<QueryAnswerModel>();
			Set<QueryReplyAnswerModel> queryReplyAnswerModels = new HashSet<QueryReplyAnswerModel>();

				for (QueryAnswerEntity answerEntity : entity.getQueryAnswerEntities()) {
					QueryAnswerModel answerModel = new QueryAnswerModel();
					answerModel.setQueryAnswer(answerEntity.getQueryAnswer());
					answerModel.setCreatedAt(answerEntity.getCreatedAt());
					answerModel.setCreatedBy(answerEntity.getCreatedBy());
					answerModel.setId(answerEntity.getId());
					if (answerEntity.getUserEntity() != null) {
						answerModel.setUserName(answerEntity.getUserEntity().getEmail());
					}
					if (answerEntity.getQueryReplyAnswerEntities() != null) {
						for (QueryReplyAnswerEntity queryReplyAnswerEntity : answerEntity
								.getQueryReplyAnswerEntities()) {
							QueryReplyAnswerModel queryReplyAnswerModel = new QueryReplyAnswerModel();
							queryReplyAnswerModel.setCreatedAt(queryReplyAnswerEntity.getCreatedAt());
							queryReplyAnswerModel.setCreatedBy(queryReplyAnswerEntity.getCreatedBy());
							queryReplyAnswerModel.setId(queryReplyAnswerEntity.getId());
							queryReplyAnswerModel.setReply(queryReplyAnswerEntity.getReply());
							queryReplyAnswerModel
									.setQueryAnswerId(queryReplyAnswerEntity.getQueryAnswerEntity().getId());
							queryReplyAnswerModels.add(queryReplyAnswerModel);
						}
						answerModel.setReplyAnswerModels(queryReplyAnswerModels);
					} // end if reply

					queryAnswerModels.add(answerModel);
				}
				model.setQueryAnswerModels(queryAnswerModels);
				model.setAnswerCount(Long.valueOf((entity.getQueryAnswerEntities().size())));
			
		} else {
			model.setAnswerCount(Long.valueOf(0));
		}

		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setQuery(entity.getQuery());
		model.setDescription(entity.getDescription());
		model.setStatus(entity.getStatus());
		return model;
	}

	public static List<QueryModel> queryDetailList(List<QueryEntity> dbList) {
		List<QueryModel> list = new ArrayList<QueryModel>();
		if (dbList != null) {
			for (QueryEntity entity : dbList) {

				QueryModel model = new QueryModel();

				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(
							entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getQueryTypeEntity() != null) {
					model.setQueryTypeId(entity.getQueryTypeEntity().getId());
					model.setQueryTypeName(entity.getQueryTypeEntity().getQueryTypeName());
				}
				if (entity.getQueryCommentEntities() != null) {
					Set<QueryCommentModel> queryCommentModels = new HashSet<QueryCommentModel>();
					for (QueryCommentEntity commentEntity : entity.getQueryCommentEntities()) {
						QueryCommentModel commentModel = new QueryCommentModel();
						commentModel.setComment(commentEntity.getComment());
						commentModel.setCreatedAt(commentEntity.getCreatedAt());
						commentModel.setCreatedBy(commentEntity.getCreatedBy());
						commentModel.setId(commentEntity.getId());
						queryCommentModels.add(commentModel);
					}
					model.setQueryCommentModels(queryCommentModels);
					model.setCommentCount(Long.valueOf((entity.getQueryCommentEntities().size())));
				} else {
					model.setCommentCount(Long.valueOf(0));
				}
				if (entity.getQueryAnswerEntities() != null) {
					Set<QueryAnswerModel> queryAnswerModels = new HashSet<QueryAnswerModel>();
					for (QueryAnswerEntity answerEntity : entity.getQueryAnswerEntities()) {
						QueryAnswerModel answerModel = new QueryAnswerModel();
						answerModel.setCreatedAt(answerEntity.getCreatedAt());
						answerModel.setCreatedBy(answerEntity.getCreatedBy());
						answerModel.setId(answerEntity.getId());
						answerEntity.setQueryAnswer(answerEntity.getQueryAnswer());
						queryAnswerModels.add(answerModel);
					}
					model.setQueryAnswerModels(queryAnswerModels);
					model.setAnswerCount(Long.valueOf((entity.getQueryAnswerEntities().size())));
				} else {
					model.setAnswerCount(Long.valueOf(0));
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setQuery(entity.getQuery());
				model.setDescription(entity.getDescription());
				model.setStatus(entity.getStatus());
				model.setId(entity.getId());
				list.add(model);
			}
		}
		return list;
	}
}
