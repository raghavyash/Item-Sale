package com.raghav.lnt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SearchQueryDTO;

@Repository
@Transactional
public class QueryServiceDaoImpl implements QueryServiceDao{
	
	@PersistenceContext
    private EntityManager entityManager;

	public List<QueryModel> getTopCountQueryDetailList() {
		Query q= entityManager.createQuery("select q.query, count(distinct qce.id) as totalComm,count(distinct qae.id) as totalAns,q.id  from QueryEntity q left join q.queryCommentEntities qce left join q.queryAnswerEntities qae group by q.id order by totalAns desc");
		q.setMaxResults(10);
		List<Object[]> dbList = q.getResultList();
		List<QueryModel> list= new ArrayList<QueryModel>();
		for(Object[] entity:dbList){
			QueryModel model= new QueryModel();
			if(entity[0].toString()!= null){
			model.setQuery(entity[0].toString());
			}
			model.setCommentCount(Long.valueOf(entity[1].toString()));
			model.setAnswerCount(Long.valueOf(entity[2].toString()));
			if(entity[3].toString() != null){
				model.setId(Long.parseLong(entity[3].toString()));
			}
			list.add(model);
		}
		return list;
	}
	public List<QueryModel> getQueryTypeCountList() {
		//Query q= entityManager.createQuery("select qt.queryTypeName, count(distinct qce.id),count(distinct qae.id),q.id  from QueryEntity q inner join q.queryTypeEntity qt left join q.queryCommentEntities qce left join q.queryAnswerEntities qae group by qt.id");
		Query q= entityManager.createQuery("select qt.queryTypeName, count(qt.id) as totalCount ,qt.id  from QueryEntity q left join q.queryTypeEntity qt  group by qt.id order by totalCount desc");
		q.setMaxResults(10);
		List<Object[]> dbList = q.getResultList();
		List<QueryModel> list= new ArrayList<QueryModel>();
		for(Object[] entity:dbList){
			QueryModel model= new QueryModel();
			if(entity[0].toString()!= null){
			model.setQueryTypeName(entity[0].toString());
			}
			model.setRecords(Long.valueOf(entity[1].toString()));
			
			if(entity[2].toString() != null){
				model.setId(Long.parseLong(entity[2].toString()));
			}
			list.add(model);
		}
		return list;
	}
	public List<QueryEntity> searchQuery(SearchQueryDTO dto){
		String str = "select DISTINCT  c from QueryEntity c join c.userEntity u left join c.queryTypeEntity qte left  join  c.queryCommentEntities qce left join c.queryAnswerEntities qae where 1=1 ";
		Query query = null;
		if (dto.getQueryTypeId() != null) {
			str = str + " and  qte.id  ='" + dto.getQueryTypeId() + "'";
		}
		if (dto.getQuery() != null) {
			str = str + " and  c.query like '%" + dto.getQuery() + "%'";
		}
		query = entityManager.createQuery(str +" ORDER BY c.createdAt DESC");
		
		List<QueryEntity> list = query.getResultList();
		int pageNumber = 1;
		int pageSize = 1000;
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		return list;
	}
}
