package com.raghav.lnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghav.lnt.model.BlogTypeModel;
import com.raghav.lnt.model.CategoryModel;
import com.raghav.lnt.model.CityModel;
import com.raghav.lnt.model.ItemModel;
import com.raghav.lnt.model.LocationModel;
import com.raghav.lnt.model.QueryTypeModel;
import com.raghav.lnt.model.SubCategoryModel;
import com.raghav.lnt.service.AdminService;

@RestController
@RequestMapping(value = { "/master_list" })
public class MasterListController {
	@Autowired
	AdminService adminService;
	@GetMapping(value = "/getcity_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getCityList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<CityModel> model = adminService.getCityList();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "City Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available City Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getcity_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getCityDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		CityModel model = adminService.getCityDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "City Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available City Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getlocation_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getLocationList(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<LocationModel> model = adminService.getLocationList(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Location Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Location Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getlocation_listBy_cityName", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getLocationListByCityName(@RequestParam String name) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<LocationModel> model = adminService.getLocationListByCityName(name);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Location Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Location Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getlocation_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getLocationDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		LocationModel model = adminService.getLocationDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Location Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Location Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getcategory_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getCategoryList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<CategoryModel> model = adminService.getCategoryList();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Category Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Category Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getcategory_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getCategoryDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		CategoryModel model = adminService.getCategoryDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "City Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available City Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getsub_category_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getSubCategoryList(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<SubCategoryModel> model = adminService.getSubCategoryList(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "SubCategory Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Category Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getsub_category_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getSubCategoryDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		SubCategoryModel model = adminService.getSubCategoryDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Sub Category Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Sub Category Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getitem_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getItemList(@RequestParam Long catId, @RequestParam Long subCatId) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<ItemModel> model = adminService.getItemList(catId, subCatId);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Category Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Category Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getitem_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getItemDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		ItemModel model = adminService.getItemDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "City Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available City Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getblog_type_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogTypeList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<BlogTypeModel> model = adminService.getBlogTypeList();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Blog Type Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Blog Type Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getblog_type_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getBlogTypeDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		BlogTypeModel model = adminService.getBlogTypeDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "City Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Blog Type Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	
	@GetMapping(value = "/getquery_type_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryTypeList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<QueryTypeModel> model = adminService.getQueryTypeList();
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Query Type Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Blog Type Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/getquery_type_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getQueryTypeDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		QueryTypeModel model = adminService.getQueryTypeDetailById(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Query Type Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Query Type Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
}
