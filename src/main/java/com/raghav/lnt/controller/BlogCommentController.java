package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.BlogCommentModel;
import com.raghav.lnt.model.BlogReplyCommentModel;
import com.raghav.lnt.service.BlogCommentService;

@RestController
@RequestMapping(value = { "/blog-comment" })
public class BlogCommentController {

	
	@Autowired
	BlogCommentService blogCommentService;
	
		@PostMapping(value = "/save-blog-comment", headers = "Accept=application/json")
		public @ResponseBody Map<String, Object> saveBlogComment(@RequestBody BlogCommentModel model) {
			Map<String, Object> response = new HashMap<String, Object>();
			if (model != null) {
				BlogCommentModel blogCommentModel = blogCommentService.saveBlogComment(model);
				if (blogCommentModel != null) {
					response.put("response_data", blogCommentModel);
					response.put("response_message", "Successfully Save Blog Comment ");
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
		@GetMapping(value = "/getBlogCommentDetail", headers = "Accept=application/json")
		public @ResponseBody Map<String, Object> getBlogCommentDetail(@RequestParam Long id) {
			Map<String, Object> response = new HashMap<String, Object>();
			if(id!= null && id > 0){
			BlogCommentModel model = blogCommentService.getBlogCommentDetailById(id);
			if (model != null) {
				response.put("response_data", model);
				response.put("response_message", "Blog Detail List");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Available Blog Detail List !!!!!");
				response.put("response_status", false);
			}
			}else{
				
			}
			return response;

		}
		@GetMapping(value = "/getBlogCommentListByBlogId", headers = "Accept=application/json")
		public @ResponseBody Map<String, Object> getBlogListByBlogId(@RequestParam Long id) {
			Map<String, Object> response = new HashMap<String, Object>();
			if(id!= null && id > 0){
			List<BlogCommentModel> model = blogCommentService.getBlogCommentDetailListByBlogId(id);
			if (model != null) {
				response.put("response_data", model);
				response.put("response_message", "Blog Comment Detail List");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Available Blog Comment Detail List !!!!!");
				response.put("response_status", false);
			}
			}else{
				response.put("response_message", "Not Available Blog Comment Detail List !!!!!");
				response.put("response_status", false);
			}
			return response;

		}
		
		//=================for Blog Comment Reply
		
		@PostMapping(value = "/save-blog-comment-reply", headers = "Accept=application/json")
		public @ResponseBody Map<String, Object> saveBlogCommentReply(@RequestBody BlogReplyCommentModel model) {
			Map<String, Object> response = new HashMap<String, Object>();
			if (model != null) {
				Boolean model2 = blogCommentService.saveBlogReplyComment(model);
				if (model2 == true) {
					response.put("response_message", "Successfully Save Blog Reply Comment ");
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
	
}
