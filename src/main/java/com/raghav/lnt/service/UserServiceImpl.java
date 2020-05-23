package com.raghav.lnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.mapper.UserMapper;
import com.raghav.lnt.model.UserModel;
import com.raghav.lnt.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	public UserModel getUserById(Long userId) {
		UserModel model = null;
		UserEntity entity = userRepository.getOne(userId);
		if (entity != null) {
			model = UserMapper.userEntityToModel(entity);
		}
		return model;
	}

	public UserModel saveUser(UserModel model) {
		UserModel model2=null;
		UserEntity entity = UserMapper.userModelToEntity(model);
		UserEntity entity2 = userRepository.save(entity);
		if(entity2!= null){
			 model2=	UserMapper. userEntityToModel(entity2);
		}
		return model2;
	}

	public List<UserModel> getAllUsers() {
		List<UserEntity> list = userRepository.findAll();

		List<UserModel> list2 = new ArrayList<UserModel>();
        if(list!= null){
		for (UserEntity userEntity : list) {
			UserModel userModel = new UserModel();
			userModel.setEmail(userEntity.getEmail());
			userModel.setFirstName(userEntity.getFirstName() + "" + userEntity.getLastName());
			userModel.setId(userEntity.getId());
			userModel.setMobile(userEntity.getMobile());
			userModel.setStatus(userEntity.getStatus());
			list2.add(userModel);
		}
      }
		return list2;
	}

	public UserModel findByUsername(String email) {
		UserModel model = null;
		UserEntity entity = userRepository.findByUsername(email);
		if (entity != null) 
			model = UserMapper.userEntityToModel(entity);
		  return model;
	}
	
	public Boolean checkUsernameDB(String email) {
		Boolean checkUser = false;
		UserEntity entity = userRepository.findByUsername(email);
		if (entity != null) 
			checkUser = true;
		  return checkUser;
	}

	public Boolean checkLogin(String email, String password) {
		Boolean check = false;
		UserEntity entity = userRepository.checkLogin(email, password);
		if (entity != null){
			check= true;
		}
		return check;
	}
	public UserModel getPasswordByUsername(String email){
		UserModel model = null;
		UserEntity entity = userRepository.findByUsername(email);
		if (entity != null) 
			model = UserMapper.userEntityToModelForPassword(entity);
		  return model; 
	 }
}
