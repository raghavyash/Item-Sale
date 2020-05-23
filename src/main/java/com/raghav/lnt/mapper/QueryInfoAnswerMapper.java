package com.raghav.lnt.mapper;

import java.util.Date;

import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.QueryInfoAnswerEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.QueryInfoAnswerModel;
import com.raghav.lnt.util.ConstantFields;

public class QueryInfoAnswerMapper {
	public static QueryInfoAnswerEntity queryInfoAnswerModelToEntity(QueryInfoAnswerModel model) {
		QueryInfoAnswerEntity entity = new QueryInfoAnswerEntity();

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
		if (ConstantFields.QUERY_COMMENTS.equals(model.getType())) {
			entity.setComments(new Long(1));
		} else if (ConstantFields.QUERY_VIEWS.equals(model.getType())) {
			entity.setViews(new Long(1));
		} else if (ConstantFields.QUERY_LIKES.equals(model.getType())) {
			entity.setLikes(new Long(1));
		} else if (ConstantFields.QUERY_UPVOTE.equals(model.getType())) {
			entity.setVotes(new Long(1));
		}
		entity.setCreatedBy(model.getUserName());
		entity.setCreatedAt(new Date());
		return entity;
	}
}
