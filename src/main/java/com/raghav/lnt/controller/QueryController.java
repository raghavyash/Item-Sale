package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.QueryAnswerModel;
import com.raghav.lnt.model.QueryCommentModel;
import com.raghav.lnt.model.QueryModel;
import com.raghav.lnt.model.QueryReplyAnswerModel;
import com.raghav.lnt.model.SearchQueryDTO;
import com.raghav.lnt.service.QueryAnswerService;
import com.raghav.lnt.service.QueryCommentService;
import com.raghav.lnt.service.QueryService;

@RestController
@RequestMapping(value = { "/query" })
public class QueryController {
	@Autowired
	QueryService queryService;
	

	@RequestMapping(value = "/save-query", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody Map<String, Object> saveQuery(@RequestBody QueryModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			QueryModel model2 = queryService.saveQuery(model);
			if (model2 != null) {
				response.put("response_data", model2);
				response.put("response_message", "Successfully Save Query ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Saved Successfully Query Detail");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Invalid Detail!!!!!");
			response.put("response_status", false);
		}
		return response;
	}

	@GetMapping(value = "/getQueryDetail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		QueryModel model = queryService.getQueryDetailById(id);
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
	@GetMapping(value = "/getQueryDetailListByQueryTypeId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryDetailListByQueryId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryModel> list = queryService.getQueryDetailListByQueryTypeId(id);
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getQueryListWithoutUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryListWithoutUserId() {
		Map<String, Object> response = new HashMap<String, Object>();
		
		List<QueryModel> list = queryService.getQueryDetailListWithoutUserId();
		if (list != null) {
			List<QueryModel> queryTopList = queryService.getTopCountQueryDetailList();
			response.put("response_data", list);
			response.put("response_data1", queryTopList);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getQueryListByUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryListByUserId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryModel> list = null;
		if (id != null && id > 0) {
			list = queryService.getQueryDetailListByUserId(id);
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", "Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		} else{
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@RequestMapping(value="/searchQueryList",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> searchQueryList(@RequestBody SearchQueryDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();

		List<QueryModel> list = queryService.searchQuery(dto);
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", "Search Query Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getQueryCountTotalDetailList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryCountTotalDetailList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryModel> model = queryService.getTopCountQueryDetailList();
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
	@GetMapping(value = "/getQueryTypeCountList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryTypeCountList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryModel> list = queryService.getQueryTypeCountList();
		if (list != null) {
			response.put("response_data", list);
			response.put("response_message", "Query Type Count Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getQueryCommentDetail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryCommentDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		QueryModel model = queryService.getQueryDetailById(id);
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

	@GetMapping(value = "/getQueryCommentListByQueryId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryCommentListByQueryId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryModel> model = queryService.getQueryDetailListByUserId(id);
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
	

}
