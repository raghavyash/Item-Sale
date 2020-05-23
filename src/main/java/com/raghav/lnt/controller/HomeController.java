package com.raghav.lnt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			return "index";
		}
}
