package com.raghav.lnt.dao;

import java.util.List;

import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchSaleDTO;

public interface SaleServiceDao {
	public List<SaleModel> getCountTotalItem() ;
	public List<SaleEntity> searchSaleItem(SearchSaleDTO dto);
}
