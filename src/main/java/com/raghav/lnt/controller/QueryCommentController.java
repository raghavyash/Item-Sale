package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryReplyCommentModel;
import com.raghav.lnt.service.QueryCommentService;
@RestController
@RequestMapping(value = { "/query-comment" })
public class QueryCommentController {

	@Autowired
	QueryCommentService queryCommentService;
	
	// for query comment module 
	
	@RequestMapping(value = "/save-query-comment", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody Map<String, Object> saveQueryComments(@RequestBody QueryCommentModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			Boolean model2 = queryCommentService.saveQueryComment(model);
			if (model2 == true) {
				response.put("response_message", "Successfully Save Query Comment ");
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
	

	//================Query Reply Comment Modeule url==================================================
		@RequestMapping(value = "/save-query-comment-reply", method = RequestMethod.POST, consumes = { "application/json" })
		public @ResponseBody Map<String, Object> saveQueryCommentReply(@RequestBody QueryReplyCommentModel model) {
			Map<String, Object> response = new HashMap<String, Object>();
			if (model != null) {
				Boolean model2 = queryCommentService.saveQueryCommentReply(model);
				if (model2 == true) {
					response.put("response_message", "Successfully Save Query Reply ");
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
