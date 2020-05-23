package com.raghav.lnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.BlogTypeEntity;
import com.raghav.lnt.entity.CategoryEntity;
import com.raghav.lnt.entity.CityEntity;
import com.raghav.lnt.entity.ItemEntity;
import com.raghav.lnt.entity.LocationEntity;
import com.raghav.lnt.entity.QueryTypeEntity;
import com.raghav.lnt.entity.SubCategoryEntity;
import com.raghav.lnt.mapper.AdminMapper;
import com.raghav.lnt.model.BlogTypeModel;
import com.raghav.lnt.model.CategoryModel;
import com.raghav.lnt.model.CityModel;
import com.raghav.lnt.model.ItemModel;
import com.raghav.lnt.model.LocationModel;
import com.raghav.lnt.model.QueryTypeModel;
import com.raghav.lnt.model.SubCategoryModel;
import com.raghav.lnt.repository.BlogTypeRepository;
import com.raghav.lnt.repository.CategoryRepository;
import com.raghav.lnt.repository.CityRepository;
import com.raghav.lnt.repository.ItemRepository;
import com.raghav.lnt.repository.LocationRepository;
import com.raghav.lnt.repository.QueryTypeRepository;
import com.raghav.lnt.repository.SubCategoryRepository;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	CityRepository cityRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	BlogTypeRepository blogTypeRepository;
	@Autowired
	QueryTypeRepository queryTypeRepository;

	public List<CityModel> getCityList() {
		List<CityModel> modellist = new ArrayList<CityModel>();
		List<CityEntity> list = cityRepository.findAll();
		for (CityEntity entity : list) {
			CityModel model = new CityModel();
			model.setCityName(entity.getCityName());
			model.setId(entity.getId());
			modellist.add(model);
		}

		return modellist;
	}

	public CityModel getCityDetailById(Long id) {
		CityModel model = null;
		CityEntity entity = cityRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.cityEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveCity(CityModel model) {
		Boolean result = false;
		if (model != null) {
			CityEntity entity1 = AdminMapper.cityModelToEntity(model);
			CityEntity entity = cityRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteCity(CityModel model) {

		Boolean result = false;
		if (model != null) {
			CityEntity entity1 = AdminMapper.cityModelToEntity(model);
			cityRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<LocationModel> getLocationList(Long id) {
		List<LocationModel> modellist = new ArrayList<LocationModel>();
		List<LocationEntity> list = locationRepository.findByIdLocation(id);
		for (LocationEntity entity : list) {
			LocationModel model = new LocationModel();
			model.setLocationName(entity.getLocationName());
			model.setId(entity.getId());
			modellist.add(model);
		}

		return modellist;
	}
	public List<LocationModel> getLocationListByCityName(String name ) {
		List<LocationModel> modellist = new ArrayList<LocationModel>();
		List<LocationEntity> list = locationRepository.findLocationListByCityName(name);
		for (LocationEntity entity : list) {
			LocationModel model = new LocationModel();
			model.setLocationName(entity.getLocationName());
			model.setId(entity.getId());
			modellist.add(model);
		}

		return modellist;
	}

	public LocationModel getLocationDetailById(Long id) {
		LocationModel model = null;
		LocationEntity entity = locationRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.locationEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveLocation(LocationModel model) {
		Boolean result = false;
		if (model != null) {
			LocationEntity entity1 = AdminMapper.locationModelToEntity(model);
			LocationEntity entity = locationRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteLocation(LocationModel model) {
		Boolean result = false;
		if (model != null) {
			LocationEntity entity1 = AdminMapper.locationModelToEntity(model);
			locationRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<ItemModel> getItemList(Long catId, Long subCatId) {
		List<ItemModel> modellist = new ArrayList<ItemModel>();
		List<ItemEntity> list = itemRepository.findAll();
		for (ItemEntity entity : list) {
			ItemModel model = new ItemModel();
			model.setId(entity.getId());
			model.setItemName(entity.getItemName());
			if (entity.getCategoryId() != null) {
				model.setCatId(entity.getCategoryId().getId());
				model.setCategoryName(entity.getCategoryId().getCategoryName());
			}
			if (entity.getSubCategoryId() != null) {
				model.setSubCategoryId(entity.getSubCategoryId().getId());
				model.setSubCategoryName(entity.getSubCategoryId().getSubCategoryName());
			}
			modellist.add(model);
		}

		return modellist;
	}

	public ItemModel getItemDetailById(Long id) {
		ItemModel model = null;
		ItemEntity entity = itemRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.itemEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveItem(ItemModel model) {
		Boolean result = false;
		if (model != null) {
			ItemEntity entity1 = AdminMapper.itemModelToEntity(model);
			ItemEntity entity = itemRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteItem(ItemModel model) {
		Boolean result = false;
		if (model != null) {
			ItemEntity entity1 = AdminMapper.itemModelToEntity(model);
			itemRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<CategoryModel> getCategoryList() {
		List<CategoryModel> modellist = new ArrayList<CategoryModel>();
		List<CategoryEntity> list = categoryRepository.findAll();
		for (CategoryEntity entity : list) {
			CategoryModel model = new CategoryModel();
			model.setCategoryName(entity.getCategoryName());
			model.setId(entity.getId());
			modellist.add(model);
		}
		return modellist;
	}

	public CategoryModel getCategoryDetailById(Long id) {
		CategoryModel model = null;
		CategoryEntity entity = categoryRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.categoryEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveCategory(CategoryModel model) {
		Boolean result = false;
		if (model != null) {
			CategoryEntity entity1 = AdminMapper.categoryModelToEntity(model);
			CategoryEntity entity = categoryRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteCategory(CategoryModel model) {
		Boolean result = false;
		if (model != null) {
			CategoryEntity entity1 = AdminMapper.categoryModelToEntity(model);
			categoryRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<SubCategoryModel> getSubCategoryList(Long id) {
		List<SubCategoryModel> modellist = new ArrayList<SubCategoryModel>();
		List<SubCategoryEntity> list = subCategoryRepository.findByIdSubCategory(id);
		for (SubCategoryEntity entity : list) {
			SubCategoryModel model = new SubCategoryModel();
			model.setSubCategoryName(entity.getSubCategoryName());
			model.setId(entity.getId());
			modellist.add(model);
		}
		return modellist;
	}

	public SubCategoryModel getSubCategoryDetailById(Long id) {
		SubCategoryModel model = null;
		SubCategoryEntity entity = subCategoryRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.subCategoryEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveSubCategory(SubCategoryModel model) {
		Boolean result = false;
		if (model != null) {
			SubCategoryEntity entity1 = AdminMapper.subCategoryModelToEntity(model);
			SubCategoryEntity entity = subCategoryRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteSubCategory(SubCategoryModel model) {
		Boolean result = false;
		if (model != null) {
			SubCategoryEntity entity1 = AdminMapper.subCategoryModelToEntity(model);
			subCategoryRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<BlogTypeModel> getBlogTypeList() {
		List<BlogTypeModel> modellist = new ArrayList<BlogTypeModel>();
		List<BlogTypeEntity> list = blogTypeRepository.findAll();
		for (BlogTypeEntity entity : list) {
			BlogTypeModel model = new BlogTypeModel();
			model.setBlogTypeName(entity.getBlogTypeName());
			model.setId(entity.getId());
			modellist.add(model);
		}
		return modellist;
	}

	public BlogTypeModel getBlogTypeDetailById(Long id) {
		BlogTypeModel model = null;
		BlogTypeEntity entity = blogTypeRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.blogTypeEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveBlogType(BlogTypeModel model) {
		Boolean result = false;
		if (model != null) {
			BlogTypeEntity entity1 = AdminMapper.blogTypeModelToEntity(model);
			BlogTypeEntity entity = blogTypeRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteBlogType(BlogTypeModel model) {
		Boolean result = false;
		if (model != null) {
			BlogTypeEntity entity1 = AdminMapper.blogTypeModelToEntity(model);
			blogTypeRepository.delete(entity1);
			result = true;
		}
		return result;
	}

	public List<QueryTypeModel> getQueryTypeList() {
		List<QueryTypeModel> modellist = new ArrayList<QueryTypeModel>();
		List<QueryTypeEntity> list = queryTypeRepository.findAll();
		for (QueryTypeEntity entity : list) {
			QueryTypeModel model = new QueryTypeModel();
			model.setQueryTypeName(entity.getQueryTypeName());
			model.setId(entity.getId());
			modellist.add(model);
		}
		return modellist;
	}

	public QueryTypeModel getQueryTypeDetailById(Long id) {
		QueryTypeModel model = null;
		QueryTypeEntity entity = queryTypeRepository.getOne(id);
		if (entity != null) {
			model = AdminMapper.queryTypeEntityToModel(entity);
		}
		return model;
	}

	public Boolean saveQueryType(QueryTypeModel model) {
		Boolean result = false;
		if (model != null) {
			QueryTypeEntity entity1 = AdminMapper.queryTypeModelToEntity(model);
			QueryTypeEntity entity = queryTypeRepository.save(entity1);
			if (entity != null) {
				result = true;
			}
		}
		return result;
	}

	public Boolean deleteQueryType(QueryTypeModel model) {
		Boolean result = false;
		if (model != null) {
			QueryTypeEntity entity1 = AdminMapper.queryTypeModelToEntity(model);
			queryTypeRepository.delete(entity1);
			result = true;
		}
		return result;
	}

}
