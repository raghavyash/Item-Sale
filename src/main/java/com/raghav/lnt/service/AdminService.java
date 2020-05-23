package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.model.BlogTypeModel;
import com.raghav.lnt.model.CategoryModel;
import com.raghav.lnt.model.CityModel;
import com.raghav.lnt.model.ItemModel;
import com.raghav.lnt.model.LocationModel;
import com.raghav.lnt.model.QueryTypeModel;
import com.raghav.lnt.model.SubCategoryModel;

public interface AdminService {
	// for city
	List<CityModel> getCityList();

	CityModel getCityDetailById(Long id);

	Boolean saveCity(CityModel model);

	Boolean deleteCity(CityModel model);

	// for location
	List<LocationModel> getLocationList(Long id);
	List<LocationModel> getLocationListByCityName(String name);

	LocationModel getLocationDetailById(Long id);

	Boolean saveLocation(LocationModel model);

	Boolean deleteLocation(LocationModel model);

	// for Item
	List<ItemModel> getItemList(Long catId, Long subCatId);

	ItemModel getItemDetailById(Long id);

	Boolean saveItem(ItemModel model);

	Boolean deleteItem(ItemModel model);

	// for Category
	List<CategoryModel> getCategoryList();

	CategoryModel getCategoryDetailById(Long id);

	Boolean saveCategory(CategoryModel model);

	Boolean deleteCategory(CategoryModel model);

	// for Sub Category
	List<SubCategoryModel> getSubCategoryList(Long id);

	SubCategoryModel getSubCategoryDetailById(Long id);

	Boolean saveSubCategory(SubCategoryModel model);

	Boolean deleteSubCategory(SubCategoryModel model);

	// for Blog Type
	List<BlogTypeModel> getBlogTypeList();

	BlogTypeModel getBlogTypeDetailById(Long id);

	Boolean saveBlogType(BlogTypeModel model);

	Boolean deleteBlogType(BlogTypeModel model);

	// for Query Type
	List<QueryTypeModel> getQueryTypeList();

	QueryTypeModel getQueryTypeDetailById(Long id);

	Boolean saveQueryType(QueryTypeModel model);

	Boolean deleteQueryType(QueryTypeModel model);

}
