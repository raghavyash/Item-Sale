package com.raghav.lnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.FeedBackEntity;
import com.raghav.lnt.mapper.FeedBackMapper;
import com.raghav.lnt.model.FeedBackModel;
import com.raghav.lnt.repository.FeedBackRepository;

@Service
@Transactional
public class FeedBackServiceImpl implements FeedBackService{
	
@Autowired
FeedBackRepository feedBackRepository;


public Boolean saveFeedBack(FeedBackModel model) {
	Boolean model2 = false;
	FeedBackEntity entity = FeedBackMapper.feedBackModelToEntity(model);
	FeedBackEntity entity2 = feedBackRepository.save(entity);
	if (entity2 != null) {
		model2 = true;
	}
	return model2;

}
}
