package com.raghav.lnt.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.dao.SaleServiceDao;
import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.mapper.SaleMapper;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchSaleDTO;
import com.raghav.lnt.repository.SaleRepository;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
	@Autowired
	SaleRepository saleRepository;
	@Autowired
	SaleServiceDao saleServiceDao;

	public SaleModel saveSale(SaleModel model) {
		SaleModel model2 = null;
		SaleEntity entity = SaleMapper.saleModelToEntity(model);
		SaleEntity entity2 = saleRepository.save(entity);
		if (entity2 != null) {
			model2 = SaleMapper.saleEntityToModel(entity2);
		}
		return model2;
	}

	public SaleModel getSaleDetailById(Long id) {
		SaleModel model = null;
		SaleEntity entity = saleRepository.getOne(id);
		if (entity != null) {
			model = SaleMapper.saleEntityToModel(entity);
		}
		return model;
	}
	public List<SaleModel> getSaleDetailListByItemId(Long itemId){
		List<SaleModel> list = null;
		List<SaleEntity> dbList = saleRepository.getSaleDetailListByItemId(itemId);
		if (dbList != null) {
			list = SaleMapper.saleDetailList(dbList);
		}
		return list;
	}
	public List<SaleModel> getSaleDetailListByUserId(Long userId) {
		List<SaleModel> list = null;
		List<SaleEntity> dbList = saleRepository.findSaleByUserId(userId);
		if (dbList != null) {
			list = SaleMapper.saleDetailList(dbList);
		}
		return list;
	}

	public List<SaleModel> searchSaleDetailList(SearchSaleDTO dto) {
		List<SaleEntity> list = null;
		/*if (dto.getCityName() != null && dto.getLocationName() == null && dto.getCategoryId() == null  && dto.getSubCategoryId() == null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCity(dto.getCityName());
			
		} else if (dto.getCityName() != null && dto.getLocationName() != null && dto.getCategoryId() == null  && dto.getSubCategoryId() == null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCityLocation(dto.getCityName(), dto.getLocationName());

		} else if (dto.getCityName() == null && dto.getLocationName() == null && dto.getCategoryId() != null  && dto.getSubCategoryId() == null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCatId(dto.getCategoryId());
			
		} else if (dto.getCityName() == null && dto.getLocationName() == null && dto.getCategoryId() != null  && dto.getSubCategoryId() != null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCatIdWithSubCatId(dto.getCategoryId(), dto.getSubCategoryId());
			
		} else if (dto.getCityName() == null && dto.getLocationName() == null && dto.getCategoryId() != null  && dto.getSubCategoryId() != null && dto.getItemId() != null) {
			list = saleRepository.searchSaleWithCatIdWithSubCatIdWithItem(dto.getCategoryId(), dto.getSubCategoryId(),
					dto.getItemId());
			
		} else if (dto.getCityName() != null && dto.getLocationName() != null && dto.getCategoryId() != null  && dto.getSubCategoryId() == null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCatIdWithCityLocation( dto.getCityName(),
					dto.getLocationName(),dto.getCategoryId());
			
		}else if (dto.getCityName() != null && dto.getLocationName() != null && dto.getCategoryId() != null && dto.getSubCategoryId() != null && dto.getItemId() == null) {
			list = saleRepository.searchSaleWithCatIdWithSubCatIdCityLocation(dto.getCityName(),
					dto.getLocationName(),dto.getCategoryId(), dto.getSubCategoryId() );
			
		}else if (dto.getCityName() != null && dto.getLocationName() != null && dto.getCategoryId() != null && dto.getSubCategoryId() != null && dto.getItemId() != null) {
			list = saleRepository.searchSaleWithCatIdWithSubCatIdWithItemCityLocation(dto.getCityName(),
					dto.getLocationName(),dto.getCategoryId(), dto.getSubCategoryId(),dto.getItemId() );
		}  else {
			list = saleRepository.searchSaleWithDefault();
		}*/
		list= saleServiceDao.searchSaleItem(dto);
		List<SaleModel> model = SaleMapper.saleDetailList(list);
		return model;
	}

	

	public String upLoadImages(SaleModel model) {
		String filePath = null;
		try {
			filePath = SaleMapper.saveUploadedFiles(model.getFiles());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	public List<SaleModel> getUpLoadImagesListBySaleId(Long saleId) {
		List<SaleModel> list = null;
		List<SaleEntity> dbList = saleRepository.findUploadImagesBySaleId(saleId);
		if (dbList != null) {
			list = SaleMapper.getImagePathListEntityToModel(dbList);
		}
		return list;
	}
	public List<SaleModel> getCountTotalItem() {
		List<SaleModel> dbList=	saleServiceDao.getCountTotalItem();
		return dbList;
	}
}
