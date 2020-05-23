package com.raghav.lnt.dao;

import java.util.List;

import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SearchQueryDTO;
import com.raghav.lnt.model.SearchSaleDTO;

public interface QueryServiceDao {
	public List<QueryModel> getTopCountQueryDetailList();
	public List<QueryModel> getQueryTypeCountList() ;
	public List<QueryEntity> searchQuery(SearchQueryDTO dto);
}
