package com.raghav.lnt.mapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.raghav.lnt.entity.CategoryEntity;
import com.raghav.lnt.entity.ItemEntity;
import com.raghav.lnt.entity.SaleEntity;
import com.raghav.lnt.entity.SubCategoryEntity;
import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.util.ReadImageFromFileServer;

public class SaleMapper {
	private static String UPLOAD_DIR = System.getProperty("user.home") +"\\"+ "postSaleimages";
	
	public static SaleEntity saleModelToEntity(SaleModel model) {
		SaleEntity entity = new SaleEntity();
		if (model.getCategoryId() != null) {
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setId(model.getCategoryId());
			entity.setCategoryEntity(categoryEntity);
		}
		if (model.getSubCategoryId() != null) {
			SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
			subCategoryEntity.setId(model.getSubCategoryId());
			entity.setSubCategoryEntity(subCategoryEntity);
		}
		if (model.getItemId() != null) {
			ItemEntity itemEntity = new ItemEntity();
			itemEntity.setId(model.getItemId());
			entity.setItemEntity(itemEntity);
		}
		/*if (model.getCityId() != null) {
			CityEntity cityEntity = new CityEntity();
			cityEntity.setId(model.getCityId());
			entity.setCityEntity(cityEntity);
		}
		if (model.getLocationId() != null) {
			LocationEntity locationEntity = new LocationEntity();
			locationEntity.setId(model.getLocationId());
			entity.setLocationEntity(locationEntity);
		}*/
		if (model.getUserId() != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(model.getUserId());
			entity.setUserEntity(userEntity);
		}
		entity.setCityName(model.getCityName());
		entity.setLocationName(model.getLocationName());
		
		entity.setCreatedAt(new Date());
		entity.setDescription(model.getDescription());
		entity.setCreatedBy(model.getUserName());
		entity.setImage1(model.getImage1());
		entity.setImage2(model.getImage2());
		entity.setImage3(model.getImage3());
		entity.setImage4(model.getImage4());
		entity.setImage5( model.getImage5());
		entity.setMobile(model.getMobile());
		entity.setOther(model.getOther());
		entity.setTitle(model.getTitle());
		entity.setPrice(model.getPrice());
		entity.setKmDriven(model.getKmDriven());
		entity.setModel(model.getModel());
		entity.setFuelType(model.getFuelType());
		entity.setYear(model.getYear());
		entity.setStatus(1);
		entity.setColor(model.getColor());
		entity.setConditionGrade(model.getConditionGrade());
		entity.setRegistrationNumber(model.getRegistrationNumber());
		entity.setNoOfOwner(model.getNoOfOwner());
		return entity;
	}

	public static SaleModel saleEntityToModel(SaleEntity entity) {
		// BeanUtils.copyProperties(model, entity);
		SaleModel model = new SaleModel();
		model.setId(entity.getId());
		if (entity.getUserEntity() != null) {
			model.setUserName(entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
			model.setUserId(entity.getUserEntity().getId());
		}
		if (entity.getCategoryEntity() != null) {
			model.setCategoryId(entity.getCategoryEntity().getId());
			model.setCategoryName(entity.getCategoryEntity().getCategoryName());
		}
		if(entity.getSubCategoryEntity()!= null){
			model.setSubCategoryId(entity.getSubCategoryEntity().getId());
			model.setSubCategoryName(entity.getSubCategoryEntity().getSubCategoryName());
		}
		if(entity.getItemEntity()!= null){
			model.setItemId(entity.getItemEntity().getId());
		   model.setItemName(entity.getItemEntity().getItemName());
		}
		model.setCityName(entity.getCityName());
		model.setLocationName(entity.getLocationName());

		model.setCreatedAt(entity.getCreatedAt());
		model.setCreatedBy(entity.getCreatedBy());
		model.setDescription(entity.getDescription());
		if(entity.getImage1()!= null){
		model.setImage1(entity.getImage1());
		ReadImageFromFileServer.loadImagePath(entity.getImage1());
		}
		if(entity.getImage2()!= null){
		model.setImage2(entity.getImage2());
		ReadImageFromFileServer.loadImagePath(entity.getImage2());
		}
		if(entity.getImage3()!= null){
		model.setImage3(entity.getImage3());
		ReadImageFromFileServer.loadImagePath(entity.getImage3());
		}
		if(entity.getImage4()!= null){
		model.setImage4(entity.getImage4());
		ReadImageFromFileServer.loadImagePath(entity.getImage4());
		}
		if(entity.getImage5()!= null){
		model.setImage5(entity.getImage5());
		ReadImageFromFileServer.loadImagePath(entity.getImage5());
		}
		
		model.setTitle(entity.getTitle());
		model.setMobile(entity.getMobile());
		model.setOther(entity.getOther());
      model.setPrice(entity.getPrice());
      model.setKmDriven(entity.getKmDriven());
      model.setModel(entity.getModel());
      model.setFuelType(entity.getFuelType());
      model.setYear(entity.getYear());
      model.setStatus(entity.getStatus());
      model.setColor(entity.getColor());
      model.setConditionGrade(entity.getConditionGrade());
      model.setRegistrationNumber(entity.getRegistrationNumber());
      model.setNoOfOwner(entity.getNoOfOwner());
		return model;
	}

	public static List<SaleModel> saleDetailList(List<SaleEntity> saleList) {
		List<SaleModel> list = new ArrayList<SaleModel>();
		if (saleList != null) {
			for (SaleEntity entity : saleList) {
				SaleModel model = new SaleModel();
				model.setId(entity.getId());
				if (entity.getUserEntity() != null) {
					model.setUserName(
							entity.getUserEntity().getFirstName() + "" + entity.getUserEntity().getLastName());
					model.setUserId(entity.getUserEntity().getId());
				}
				if (entity.getCategoryEntity() != null) {
					model.setCategoryId(entity.getCategoryEntity().getId());
					model.setCategoryName(entity.getCategoryEntity().getCategoryName());
				}
				if(entity.getSubCategoryEntity()!= null){
					model.setSubCategoryId(entity.getSubCategoryEntity().getId());
					model.setSubCategoryName(entity.getSubCategoryEntity().getSubCategoryName());
				}
				if(entity.getItemEntity()!= null){
					model.setItemId(entity.getItemEntity().getId());
				   model.setItemName(entity.getItemEntity().getItemName());
				}
				model.setCityName(entity.getCityName());
				model.setLocationName(entity.getLocationName());
				model.setCreatedAt(entity.getCreatedAt());
				model.setCreatedBy(entity.getCreatedBy());
				model.setDescription(entity.getDescription());
				if(entity.getImage1()!= null){
					model.setImage1(entity.getImage1());
					ReadImageFromFileServer.loadImagePath(entity.getImage1());
					}
					if(entity.getImage2()!= null){
					model.setImage2(entity.getImage2());
					ReadImageFromFileServer.loadImagePath(entity.getImage2());
					}
					if(entity.getImage3()!= null){
					model.setImage3(entity.getImage3());
					ReadImageFromFileServer.loadImagePath(entity.getImage3());
					}
					if(entity.getImage4()!= null){
					model.setImage4(entity.getImage4());
					ReadImageFromFileServer.loadImagePath(entity.getImage4());
					}
					if(entity.getImage5()!= null){
					model.setImage5(entity.getImage5());
					ReadImageFromFileServer.loadImagePath(entity.getImage5());
					}
				model.setTitle(entity.getTitle());
				model.setMobile(entity.getMobile());
				model.setOther(entity.getOther());
				model.setPrice(entity.getPrice());
			      model.setKmDriven(entity.getKmDriven());
			      model.setModel(entity.getModel());
			      model.setFuelType(entity.getFuelType());
			      model.setYear(entity.getYear());
			      model.setStatus(entity.getStatus());
			      model.setColor(entity.getColor());
			      model.setConditionGrade(entity.getConditionGrade());
			      model.setRegistrationNumber(entity.getRegistrationNumber());
			      model.setNoOfOwner(entity.getNoOfOwner());
				list.add(model);
			}
		}
		return list;
	}
	
	public static String saveUploadedFiles(MultipartFile[] files) throws IOException {

		// Make sure directory exists!
		File uploadDir = new File(UPLOAD_DIR);
		uploadDir.mkdirs();

		StringBuilder sb = new StringBuilder();

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}
			String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();

			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFilePath);
			Files.write(path, bytes);
			sb.append(uploadFilePath).append(", ");
		}
		return sb.toString();
	}
	public static List<SaleModel> getImagePathListEntityToModel(List<SaleEntity> saleList) {
		List<SaleModel> list = new ArrayList<SaleModel>();
		if (saleList != null) {
			for (SaleEntity entity : saleList) {
				SaleModel model = new SaleModel();
				model.setId(entity.getId());
				model.setImage1(entity.getImage1());
				model.setImage2(entity.getImage2());
				model.setImage3(entity.getImage3());
				model.setImage4(entity.getImage4());
				model.setImage5(entity.getImage5());
				list.add(model);
				
			}
		}
		return list;
	}
}
