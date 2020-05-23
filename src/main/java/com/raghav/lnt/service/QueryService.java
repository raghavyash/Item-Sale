package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryInfoAnswerModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.model.QueryReplyCommentModel;
import com.raghav.lnt.model.SearchQueryDTO;

public interface QueryService {
	QueryModel saveQuery(QueryModel model);
	QueryModel getQueryDetailById(Long id);
	List<QueryModel> getQueryDetailListByQueryTypeId(Long id);
	List<QueryModel> getQueryDetailListByUserId(Long userId);
	List<QueryModel> getQueryDetailListWithoutUserId();
	 List<QueryModel> searchQueryList(QueryModel model);
	List<QueryModel> searchQuery(SearchQueryDTO dto);
	
	List<QueryModel> getTopCountQueryDetailList();
	List<QueryModel> getQueryTypeCountList();
	
	
	
	
}
