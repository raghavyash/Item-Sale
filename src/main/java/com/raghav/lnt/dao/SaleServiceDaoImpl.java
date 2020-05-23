package com.raghav.lnt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.CategoryEntity;
import com.raghav.lnt.entity.ItemEntity;
import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.entity.SubCategoryEntity;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchSaleDTO;

@Transactional
@Repository
public class SaleServiceDaoImpl implements SaleServiceDao {
	@PersistenceContext
	private EntityManager entityManager;

	public List<SaleModel> getCountTotalItem() {
		Query q = entityManager.createQuery(
				"SELECT i.itemName,i.id,count(i.id) FROM SaleEntity s left join s.itemEntity i  group by i.id");
		List<Object[]> dbList = q.getResultList();
		List<SaleModel> list = new ArrayList<SaleModel>();
		for (Object[] entity : dbList) {
			SaleModel model = new SaleModel();
			model.setItemName(entity[0].toString());
			model.setItemId((Long.valueOf(entity[1].toString())));
			model.setItemCount(Long.valueOf(entity[2].toString()));
			list.add(model);
		}
		return list;
	}

	public List<SaleEntity> searchSaleItem(SearchSaleDTO dto) {
		
		String str = "select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s join c.itemEntity i where 1=1  ";
		Query query = null;
		if (dto.getCityName() != null) {
			str = str + " and  c.cityName  ='" + dto.getCityName() + "'";
		}
		if (dto.getLocationName() != null) {
			str = str + " and  c.locationName ='" + dto.getLocationName() + "'";
		}
		if (dto.getCategoryId() != null) {
			str = str + " and u.id =" + dto.getCategoryId();
		}
		if (dto.getSubCategoryId() != null) {
			str = str + " and s.id =" + dto.getSubCategoryId();
		}
		if (dto.getItemId() != null) {
			str = str + "  and i.id =" + dto.getItemId();
		}
		query = entityManager.createQuery(str +" ORDER BY c.createdAt DESC");
		
		List<SaleEntity> list = query.getResultList();
		int pageNumber = 1;
		int pageSize = 1000;
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		return list;
	}

}
