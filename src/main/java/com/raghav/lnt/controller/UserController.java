package com.raghav.lnt.controller;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.UserModel;
import com.raghav.lnt.service.UserService;
import com.raghav.lnt.util.MailUtility;

@RestController
@RequestMapping(value = { "/user" })
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
    public JavaMailSender mailSender;

	@PostMapping(value = "/signup", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> createUser(@RequestBody UserModel model, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();

		Boolean checkUserInDB = userService.checkUsernameDB(model.getEmail());
		if (checkUserInDB != true) {
			UserModel model2 = userService.saveUser(model);
			if (model2 != null) {
				session.setAttribute("userVo", model2);
				response.put("response_data", model2);
				response.put("response_message", "successfully register user");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		} else {
			response.put("response_message", "username is already register !!! Please reset your password");
			response.put("response_status", false);
		}
		return response;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkLogin(@RequestBody UserModel model, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		String email = model.getEmail();
		String password = model.getPassword();
		if (email != null && password != null) {
			Boolean result = userService.checkLogin(email, password);
			if (result == true) {
				UserModel model1 = userService.findByUsername(email);
				UUID uuid = UUID.randomUUID();
				String token = uuid.toString().replace("-", "");
				response.put("token", token);
				response.put("userId", model1.getId());
				response.put("response_data", model1);
				session.setAttribute("userVo", model1);
				response.put("response_message", "successfully login");
				response.put("response_status", true);
			} else {
				response.put("response_message", "username and password is  invalid!!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "username and password is blank ");
			response.put("response_status", false);
		}
		return response;
	}
	@PostMapping(value = "/forgotpassword", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> forgotPassword(@RequestBody UserModel model) {
		Map<String, Object> response = new HashMap<String, Object>();

		Boolean checkUserInDB = userService.checkUsernameDB(model.getEmail());
		if (checkUserInDB != true) {
			
			UserModel userModelForPassword = userService.getPasswordByUsername(model.getEmail());
			if (userModelForPassword != null) {
				response.put("response_message", "Email send successfully");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not send successfully !!! Please try again");
				response.put("response_status", true);
			}
		} else {
			response.put("response_message", "Email/username is not register !!! Please signup");
			response.put("response_status", false);
		}
		return response;
	}
	@GetMapping(value = "/getUserList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getUserList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<UserModel> model = userService.getAllUsers();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "User Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available User Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
}
