package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchSaleDTO;

public interface SaleService {
	SaleModel saveSale(SaleModel model);
	SaleModel getSaleDetailById(Long id);
	List<SaleModel> getSaleDetailListByItemId(Long itemId);
	List<SaleModel> getSaleDetailListByUserId(Long userId);
	List<SaleModel> searchSaleDetailList(SearchSaleDTO dto);
	String upLoadImages(SaleModel model);
	List<SaleModel> getUpLoadImagesListBySaleId(Long userId);
	public List<SaleModel> getCountTotalItem() ;
	
	
	
}
