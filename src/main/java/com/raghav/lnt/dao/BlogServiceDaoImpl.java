package com.raghav.lnt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SearchBlogDTO;
import com.raghav.lnt.model.SearchSaleDTO;

@Repository

public class BlogServiceDaoImpl implements BlogServiceDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<BlogModel> getTopCountBlogDetailList() {
		Query q= entityManager.createQuery("select b.title, count(distinct bc.id) as totalCount,b.id  from BlogEntity b left join b.blogCommentEntities bc group by b.id order by totalCount desc");
		q.setMaxResults(10);
		List<Object[]> dbList = q.getResultList();
		List<BlogModel> list= new ArrayList<BlogModel>();
		for(Object[] entity:dbList){
			BlogModel model= new BlogModel();
			if(null !=entity[0].toString()){
			model.setTitle(entity[0].toString());
			}
			if(entity[1].toString() != null){
			model.setCommentCount(Long.valueOf(entity[1].toString()));
			}
			if(entity[2].toString() != null){
				model.setId(Long.parseLong(entity[2].toString()));
			}
			list.add(model);
		}
		return list;
	}
	public List<BlogModel> getBlogTypeCountList() {
		Query q= entityManager.createQuery("select bt.blogTypeName, count(bt.id) as totalCount ,bt.id  from BlogEntity b left join b.blogTypeEntity bt  group by bt.id  order by totalCount desc");
		q.setMaxResults(10);
		List<Object[]> dbList = q.getResultList();
		List<BlogModel> list= new ArrayList<BlogModel>();
		for(Object[] entity:dbList){
			BlogModel model= new BlogModel();
			if(null !=entity[0].toString()){
			model.setBlogTypeName(entity[0].toString());
			}
			if(entity[1].toString() != null){
			model.setRecords(Long.valueOf(entity[1].toString()));
			}
			if(entity[2].toString() != null){
				model.setId(Long.parseLong(entity[2].toString()));
			}
			list.add(model);
		}
		return list;
	}
	public List<BlogEntity> searchBlog(SearchBlogDTO dto){
		
		String str = "select DISTINCT  c from BlogEntity c join c.userEntity u left  join  c.blogCommentEntities qce left join c.blogTypeEntity bte where 1=1 ";
		Query query = null;
		if (dto.getBlogTypeId() != null) {
			str = str + " and  bte.id  ='" + dto.getBlogTypeId() + "'";
		}
		if (dto.getTitle() != null) {
			str = str + " and  c.title like '%" + dto.getTitle() + "%'";
		}
		query = entityManager.createQuery(str +" ORDER BY c.createdAt DESC");
		
		List<BlogEntity> list = query.getResultList();
		int pageNumber = 1;
		int pageSize = 1000;
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		return list;
	}
}
