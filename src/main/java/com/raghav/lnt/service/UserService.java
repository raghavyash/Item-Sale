package com.raghav.lnt.service;

import java.util.List;

import com.raghav.lnt.entity.UserEntity;
import com.raghav.lnt.model.UserModel;

public interface UserService {
	UserModel getUserById(Long userId);

	UserModel saveUser(UserModel entity);

	List<UserModel> getAllUsers();

	Boolean checkLogin(String email, String password);

	UserModel findByUsername(String email);
	
   Boolean checkUsernameDB(String email) ;
   
   UserModel getPasswordByUsername(String email);

}
