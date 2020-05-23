package com.raghav.lnt.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.QueryAnswerModel;

public class QueryAnswerMapper {
	public static QueryAnswerEntity queryAnswerModelToEntity(QueryAnswerModel model) {
		QueryAnswerEntity entity = new QueryAnswerEntity();

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
		entity.setQueryAnswer(model.getQueryAnswer());
		entity.setCreatedBy(model.getUserName());
		return entity;
	}
	public static QueryAnswerModel queryAnswerEntityToModel(QueryAnswerEntity entity) {
		QueryAnswerModel model = new QueryAnswerModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getQueryEntity() != null) {
			model.setQueryId(entity.getQueryEntity().getId());
			model.setQuery(entity.getQueryEntity().getQuery());
		}
		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setId(entity.getId());
		return model;
	}
	public static List<QueryAnswerModel> queryAnswerDetailList(List<QueryAnswerEntity> dbList) {
		List<QueryAnswerModel> list = new ArrayList<QueryAnswerModel>();
		if (dbList != null) {
			for (QueryAnswerEntity entity : dbList) {
				QueryAnswerModel model = new QueryAnswerModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getQueryEntity() != null) {
					model.setQueryId(entity.getQueryEntity().getId());
					model.setQuery(entity.getQueryEntity().getQuery());
				}
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setId(entity.getId());
				list.add(model);
			}
		}
		return list;
	}
}
