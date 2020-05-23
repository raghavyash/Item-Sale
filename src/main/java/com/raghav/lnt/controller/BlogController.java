package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchBlogDTO;
import com.raghav.lnt.service.BlogService;
import com.raghav.lnt.service.SaleService;
@RestController
@RequestMapping(value = { "/blog" })
public class BlogController {
	
	@Autowired
	BlogService blogService;
	

	@RequestMapping(value="/save-blog",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBlog(@RequestBody BlogModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			BlogModel blogData = blogService.saveBlog(model);
			if (blogData != null) {
				response.put("response_data", blogData);
				response.put("response_message", "Successfully Save Blog Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Invalid Detail!!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Invalid Detail!!!!!");
			response.put("response_status", false);
		}
		return response;
	}

	@GetMapping(value = "/getBlogDetail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if(id != null && id> 0){
		BlogModel model = blogService.getBlogDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Blog Detail List !!!!!");
			response.put("response_status", false);
		}
		}else {
			response.put("response_message", "Not Available Blog Detail !!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getBlogDetailListByBlogTypeId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogDetailListByBlogId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<BlogModel> list = blogService.getBlogDetailListByBlogTypeId(id);
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", "Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getBlogListByUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogListByUserId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if(id != null && id> 0){
		List<BlogModel> model = blogService.getBlogDetailListByUserId(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Blog Detail List !!!!!");
			response.put("response_status", false);
		}
		}else{
			response.put("response_message", "Not Available Blog Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getBlogListWithoutUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryListWithoutUserId() {
		Map<String, Object> response = new HashMap<String, Object>();
		
		List<BlogModel> list = blogService.getQueryDetailListWithoutUserId();
		if (list != null) {
			List<BlogModel> blogTopList = blogService.getTopCountBlogDetailList();
			response.put("response_data", list);
			response.put("response_data1", blogTopList);
			response.put("response_message", "Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@RequestMapping(value="/searchBlogList",method = RequestMethod.POST ,headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> searchBlogList(@RequestBody SearchBlogDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		List<BlogModel> list = blogService.searchBlog(dto);
		if(list!= null){
		response.put("response_data", list);
			response.put("response_message", "Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getBlogCountTotalDetailList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryCountTotalDetailList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<BlogModel> model = blogService.getTopCountBlogDetailList();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", " Top Blog Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getBlogTypeCountList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogTypeCountList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<BlogModel> list = blogService.getBlogTypeCountList();
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", " Top Blog type Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
}
