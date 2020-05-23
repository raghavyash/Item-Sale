package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryReplyCommentModel;

public interface QueryCommentService {
	    // for Query Commnet
		 Boolean saveQueryComment(QueryCommentModel model);
		 QueryCommentModel getQueryCommentDetailById(Long id);
		 List<QueryCommentModel> getQueryCommentListByQueryId(Long queryId);
		 
		 // for Query Comment Reply
		 Boolean saveQueryCommentReply(QueryReplyCommentModel model);
		
}
