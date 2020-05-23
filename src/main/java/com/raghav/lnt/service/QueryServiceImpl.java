package com.raghav.lnt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.dao.QueryServiceDao;
import com.raghav.lnt.entity.QueryAnswerEntity;
import com.raghav.lnt.entity.QueryCommentEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.QueryInfoAnswerEntity;
import com.raghav.lnt.entity.QueryReplyAnswerEntity;
import com.raghav.lnt.entity.QueryReplyCommentEntity;
import com.raghav.lnt.mapper.QueryAnswerMapper;
import com.raghav.lnt.mapper.QueryCommentMapper;
import com.raghav.lnt.mapper.QueryInfoAnswerMapper;
import com.raghav.lnt.mapper.QueryMapper;
import com.raghav.lnt.mapper.QueryReplyMapper;
import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryInfoAnswerModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.model.QueryReplyCommentModel;
import com.raghav.lnt.model.SearchQueryDTO;
import com.raghav.lnt.repository.QueryAnswerRepository;
import com.raghav.lnt.repository.QueryCommentRepository;
import com.raghav.lnt.repository.QueryInfoAnswerRepository;
import com.raghav.lnt.repository.QueryReplyAnswerRepository;
import com.raghav.lnt.repository.QueryReplyCommentRepository;
import com.raghav.lnt.repository.QueryRepository;

@Service
@Transactional
public class QueryServiceImpl implements QueryService {
	@Autowired
	QueryRepository queryRepository;
	
	@Autowired
	QueryInfoAnswerRepository queryInfoAnswerRepository;
	
	@Autowired
	QueryServiceDao queryServiceDao;
	

	public QueryModel saveQuery(QueryModel model) {
		QueryModel model2 = null;
		QueryEntity entity = QueryMapper.queryModelToEntity(model);
		QueryEntity entity2 = queryRepository.save(entity);
		if (entity2 != null) {
			 model2=QueryMapper.queryEntityToModel(entity2);
			//check = true;
		}
		return model2;
	}
	
	
	public QueryModel getQueryDetailById(Long id) {
		QueryModel model = null;
		QueryEntity entity = queryRepository.getQueryDetailByQueryId(id);
		if (entity != null) {
			model = QueryMapper.queryEntityToModel(entity);
		}
		return model;
	}
	public List<QueryModel> getQueryDetailListByQueryTypeId(Long id){
		List<QueryModel> list = null;
		List<QueryEntity> dbList =	queryRepository.findQueryDetailListByQueryTypeId(id);
		if (dbList != null) {
			//Set<QueryEntity> setList= new HashSet<QueryEntity>(dbList);
			list = QueryMapper.queryDetailList(dbList);
		}
		return list;
	}
	public List<QueryModel> getQueryDetailListByUserId(Long userId) {
		List<QueryModel> list = null;
		List<QueryEntity> dbList = queryRepository.findQueryByUserId(userId);
		if (dbList != null) {
			//Set<QueryEntity> setList= new HashSet<QueryEntity>(dbList);
			list = QueryMapper.queryDetailList(dbList);
		}
		return list;
	}
	 
   public	List<QueryModel> getQueryDetailListWithoutUserId(){
		List<QueryModel> list = null;
		List<QueryEntity> dbList = queryRepository.findQueryListWithoutUserId();
		if (dbList != null) {
			//Set<QueryEntity> setList= new HashSet<QueryEntity>(dbList);
			list = QueryMapper.queryDetailList(dbList);
		}
		return list;
	}
	public List<QueryModel> searchQueryList(QueryModel model) {
		List<QueryModel> list = null;
		List<QueryEntity> dbList =null;
		if(model.getId()!= null && model.getSearch()== null){
			dbList = queryRepository.searchQueryListByQueryTypeId(model.getId());
		}else{
			dbList = queryRepository.searchQueryListByQueryTypeIdOrName(model.getId(),model.getSearch());
		}
		if (dbList != null) {
			list = QueryMapper.queryDetailList(dbList);
		}
		return list;
	}

	public List<QueryModel> searchQuery(SearchQueryDTO dto) {
		List<QueryModel> list = null;
		List<QueryEntity> dbList =queryServiceDao.searchQuery(dto);
		
		if (dbList != null) {
			list = QueryMapper.queryDetailList(dbList);
		}
		return list;
	}
	
	public List<QueryModel> getTopCountQueryDetailList() {
		List<QueryModel> dbList=	queryServiceDao.getTopCountQueryDetailList();
		return dbList;
	}
	public List<QueryModel> getQueryTypeCountList(){
		List<QueryModel> dbList=	queryServiceDao.getQueryTypeCountList();
		return dbList;
	}
	
	

	
	

//===================Query Answer Reply ==============================

	

	
	
	
}
