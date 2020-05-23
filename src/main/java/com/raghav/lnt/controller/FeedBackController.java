package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.FeedBackModel;
import com.raghav.lnt.service.FeedBackService;
@RestController
@RequestMapping(value = { "/feedback" })
public class FeedBackController {
	@Autowired
	FeedBackService feedBackService;
	
	@RequestMapping(value="/save-feedback",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveFeedBack(@RequestBody FeedBackModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			Boolean model2 = feedBackService.saveFeedBack(model);
			if (model2 == true) {
				response.put("response_message", "Successfully Save FeedBack Data ");
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
