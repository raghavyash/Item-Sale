package com.raghav.lnt.service;

import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.QueryReplyAnswerEntity;
import com.raghav.lnt.mapper.QueryAnswerMapper;
import com.raghav.lnt.mapper.QueryReplyMapper;
import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.repository.QueryAnswerRepository;
import com.raghav.lnt.repository.QueryReplyAnswerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QueryAnswerServiceImpl implements QueryAnswerService {

	@Autowired
	QueryAnswerRepository queryAnswerRepository;

	@Autowired
	QueryReplyAnswerRepository queryReplyAnswerRepository;

	// =============Query Answer
	// Service==================================================================

	public QueryAnswerModel saveQueryAnswer(QueryAnswerModel model) {
		QueryAnswerModel model2 = null;
		QueryAnswerEntity entity = QueryAnswerMapper.queryAnswerModelToEntity(model);
		QueryAnswerEntity entity2 = queryAnswerRepository.save(entity);
		if (entity2 != null) {
			model2 = QueryAnswerMapper.queryAnswerEntityToModel(entity2);
		}
		return model2;
	}

	public QueryAnswerModel getQueryAnswerDetailById(Long id) {
		QueryAnswerModel model = null;
		QueryAnswerEntity entity = queryAnswerRepository.getOne(id);
		if (entity != null) {
			model = QueryAnswerMapper.queryAnswerEntityToModel(entity);
		}
		return model;
	}

	public List<QueryAnswerModel> getQueryAnswerDetailListByUserId(Long userId) {
		List<QueryAnswerModel> list = null;
		List<QueryAnswerEntity> dbList = queryAnswerRepository.findQueryAnswerByUserId(userId);
		if (dbList != null) {
			list = QueryAnswerMapper.queryAnswerDetailList(dbList);
		}
		return list;
	}

	public List<QueryAnswerModel> getQueryAnswerDetailListByQueryId(Long queryId) {
		List<QueryAnswerModel> list = null;
		List<QueryAnswerEntity> dbList = queryAnswerRepository.findQueryAnswerByQueryId(queryId);
		if (dbList != null) {
			list = QueryAnswerMapper.queryAnswerDetailList(dbList);
		}
		return list;
	}

	// ============ Query Answer Reply Modeule Service Imple

	public Boolean saveQueryAnswerReply(QueryReplyAnswerModel model) {
		Boolean model2 = false;
		QueryReplyAnswerEntity entity = QueryReplyMapper.queryAnswerReplyModelToEntity(model);
		QueryReplyAnswerEntity entity2 = queryReplyAnswerRepository.save(entity);
		if (entity2 != null) {
			model2 = true;
		}
		return model2;
	}

}
