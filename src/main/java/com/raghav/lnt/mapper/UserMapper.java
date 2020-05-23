package com.raghav.lnt.mapper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.UserModel;

public class UserMapper {
	public static UserEntity userModelToEntity(UserModel model) {
		UserEntity entity = new UserEntity();
		
			entity.setEmail(model.getEmail());
			entity.setFirstName(model.getFirstName());
			entity.setLastName(model.getLastName());
			entity.setMobile(model.getMobile());
			entity.setPassword(model.getPassword());
			entity.setStatus(1);
			entity.setEnabled(true);
		
		return entity;
	}

	public static UserModel userEntityToModel(UserEntity entity) {
		UserModel model = new UserModel();
		model.setEmail(entity.getEmail());
		model.setFirstName(entity.getFirstName());
		model.setLastName(entity.getLastName());
		model.setId(entity.getId());
		model.setMobile(entity.getMobile());
		model.setStatus(entity.getStatus());
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}
	public static UserModel userEntityToModelForPassword(UserEntity entity) {
		UserModel model = new UserModel();
		model.setPassword(entity.getPassword());
		model.setFirstName(entity.getFirstName());
		model.setLastName(entity.getLastName());
		model.setId(entity.getId());
		model.setMobile(entity.getMobile());
		model.setStatus(entity.getStatus());
		// userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return model;
	}
}
