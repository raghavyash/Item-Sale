package com.raghav.lnt.mapper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.raghav.lnt.entity.BlogTypeEntity;
import com.raghav.lnt.entity.CategoryEntity;
import com.raghav.lnt.entity.CityEntity;
import com.raghav.lnt.entity.ItemEntity;
import com.raghav.lnt.entity.LocationEntity;
import com.raghav.lnt.entity.QueryTypeEntity;
import com.raghav.lnt.entity.SubCategoryEntity;
import com.raghav.lnt.model.BlogTypeModel;
import com.raghav.lnt.model.CategoryModel;
import com.raghav.lnt.model.CityModel;
import com.raghav.lnt.model.ItemModel;
import com.raghav.lnt.model.LocationModel;
import com.raghav.lnt.model.QueryTypeModel;
import com.raghav.lnt.model.SubCategoryModel;

public class AdminMapper {
	public static CityEntity cityModelToEntity(CityModel model) {
		CityEntity entity = new CityEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static CityModel cityEntityToModel(CityEntity entity) {
		CityModel model = new CityModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}
	// ---- for Location Model

	public static LocationEntity locationModelToEntity(LocationModel model) {
		LocationEntity entity = new LocationEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static LocationModel locationEntityToModel(LocationEntity entity) {
		LocationModel model = new LocationModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}

	public static ItemEntity itemModelToEntity(ItemModel model) {
		ItemEntity entity = new ItemEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static ItemModel itemEntityToModel(ItemEntity entity) {
		ItemModel model = new ItemModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}

	// for category mapper

	public static CategoryEntity categoryModelToEntity(CategoryModel model) {
		CategoryEntity entity = new CategoryEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static CategoryModel categoryEntityToModel(CategoryEntity entity) {
		CategoryModel model = new CategoryModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}

	// for sub category mapper

	public static SubCategoryEntity subCategoryModelToEntity(SubCategoryModel model) {
		SubCategoryEntity entity = new SubCategoryEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static SubCategoryModel subCategoryEntityToModel(SubCategoryEntity entity) {
		SubCategoryModel model = new SubCategoryModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}

	// for Blog Type mapper

	public static BlogTypeEntity blogTypeModelToEntity(BlogTypeModel model) {
		BlogTypeEntity entity = new BlogTypeEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static BlogTypeModel blogTypeEntityToModel(BlogTypeEntity entity) {
		BlogTypeModel model = new BlogTypeModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}

	// for Query Type mapper

	public static QueryTypeEntity queryTypeModelToEntity(QueryTypeModel model) {
		QueryTypeEntity entity = new QueryTypeEntity();
		try {
			BeanUtils.copyProperties(entity, model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	public static QueryTypeModel queryTypeEntityToModel(QueryTypeEntity entity) {
		QueryTypeModel model = new QueryTypeModel();
		try {
			BeanUtils.copyProperties(model, entity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}
}
