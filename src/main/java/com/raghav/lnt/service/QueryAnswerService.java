package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;

public interface QueryAnswerService {
	///== for Query Answer Modeule
	QueryAnswerModel saveQueryAnswer(QueryAnswerModel model);
	QueryAnswerModel getQueryAnswerDetailById(Long id);
	List<QueryAnswerModel> getQueryAnswerDetailListByUserId(Long userId);
	List<QueryAnswerModel> getQueryAnswerDetailListByQueryId(Long userId);
	
	///== for Query Answer Reply Module
	Boolean saveQueryAnswerReply(QueryReplyAnswerModel model);
	
}
