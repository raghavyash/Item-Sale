package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.service.QueryAnswerService;

@RestController
@RequestMapping(value = { "/query-answer" })
public class QueryAnswerController {
	@Autowired
	QueryAnswerService queryAnswerService;
	
	
	@RequestMapping(value = "/save-query-answer", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody Map<String, Object> saveQueryAnswer(@RequestBody QueryAnswerModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			QueryAnswerModel queryAnswerModel = queryAnswerService.saveQueryAnswer(model);
			if (queryAnswerModel != null) {
				response.put("response_data", queryAnswerModel);
				response.put("response_message", "Successfully Save Query Answer ");
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

	@GetMapping(value = "/getQueryAnswerDetail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryAnswerDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		QueryAnswerModel model = queryAnswerService.getQueryAnswerDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getQueryAnswerListByQueryId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryAnswerListByQueryId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryAnswerModel> model = queryAnswerService.getQueryAnswerDetailListByQueryId(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getQueryAnswerListByUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryAnswerListByUserId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryAnswerModel> model = queryAnswerService.getQueryAnswerDetailListByUserId(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	//================Query Reply Answer==================================================
		@RequestMapping(value = "/save-query-answer-reply", method = RequestMethod.POST, consumes = { "application/json" })
		public @ResponseBody Map<String, Object> saveQueryReplyAnswer(@RequestBody QueryReplyAnswerModel model) {
			Map<String, Object> response = new HashMap<String, Object>();
			if (model != null) {
				Boolean model2 = queryAnswerService.saveQueryAnswerReply(model);
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
