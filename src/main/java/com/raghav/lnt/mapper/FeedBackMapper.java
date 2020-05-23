package com.raghav.lnt.mapper;

import java.util.Date;

import com.raghav.lnt.entity.FeedBackEntity;
import com.raghav.lnt.model.FeedBackModel;

public class FeedBackMapper {
	public static FeedBackEntity feedBackModelToEntity(FeedBackModel model) {
		FeedBackEntity entity = new FeedBackEntity();
		entity.setCreatedAt(new Date());
		entity.setEmail(model.getEmail());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		entity.setMessage(model.getMessage());
		entity.setPhone(model.getPhone());
		entity.setReview(model.getReview());
		return entity;
	}
}
