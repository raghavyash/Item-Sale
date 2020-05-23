package com.raghav.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.QueryCommentEntity;
import com.raghav.lnt.entity.QueryReplyCommentEntity;
import com.raghav.lnt.mapper.QueryCommentMapper;
import com.raghav.lnt.mapper.QueryReplyMapper;
import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryReplyCommentModel;
import com.raghav.lnt.repository.QueryCommentRepository;
import com.raghav.lnt.repository.QueryReplyCommentRepository;

@Service
@Transactional
public class QueryCommentServiceImpl implements QueryCommentService{
	@Autowired
	QueryCommentRepository queryCommentRepository;
	@Autowired
	QueryReplyCommentRepository queryReplyCommentRepository;
	
	//==============Query Comment Service====================
	
		public Boolean saveQueryComment(QueryCommentModel model) {
			Boolean check = false;
			QueryCommentEntity entity = QueryCommentMapper.queryCommentModelToEntity(model);
			QueryCommentEntity entity2 = queryCommentRepository.save(entity);
			if (entity2 != null) {
				check = true;
			}
			return check;
		}
		public QueryCommentModel getQueryCommentDetailById(Long id){
			QueryCommentModel model = null;
			QueryCommentEntity entity = queryCommentRepository.getOne(id);
			if (entity != null) {
				model = QueryCommentMapper.queryCommentEntityToModel(entity);
			}
			return model;
		}
		public List<QueryCommentModel> getQueryCommentListByQueryId(Long queryId){
			List<QueryCommentModel> list = null;
			List<QueryCommentEntity> dbList = queryCommentRepository.findQueryCommentByQueryId(queryId);
			if (dbList != null) {
				list = QueryCommentMapper.queryCommentDetailList(dbList);
			}
			return list;
		 }
		
		//==============Query Reply Comment Service====================
		
		
		public Boolean saveQueryCommentReply(QueryReplyCommentModel model){
			Boolean model2 = false;
			QueryReplyCommentEntity entity = QueryReplyMapper.queryCommentReplyModelToEntity(model);
			QueryReplyCommentEntity entity2 = queryReplyCommentRepository.save(entity);
			if (entity2 != null) {
				model2 = true;
			}
			return model2;
		}
}
