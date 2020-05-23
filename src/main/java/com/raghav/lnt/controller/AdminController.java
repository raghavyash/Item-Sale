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

import com.raghav.lnt.model.BlogTypeModel;
import com.raghav.lnt.model.CategoryModel;
import com.raghav.lnt.model.CityModel;
import com.raghav.lnt.model.ItemModel;
import com.raghav.lnt.model.LocationModel;
import com.raghav.lnt.model.QueryTypeModel;
import com.raghav.lnt.model.SubCategoryModel;
import com.raghav.lnt.service.AdminService;

@RestController
@RequestMapping(value = { "/admin" })
public class AdminController {

	@Autowired
	AdminService adminService;

	// For city Module

	

	@PostMapping(value = "/save_city", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveCity(@RequestBody CityModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveCity(model);
		if (check == true) {
			response.put("response_message", "Successfully Save City Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save City Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_city", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteCity(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			CityModel model = new CityModel();
			model.setId(id);
			Boolean check = adminService.deleteCity(model);
			if (check == true) {
				response.put("response_message", "Successfully Delete City Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Delete City Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "City Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	// ==========Location
	// Module===================================================================

	

	@PostMapping(value = "/save_location", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveLocation(@RequestBody LocationModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveLocation(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Location Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Location Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_location", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteLocation(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			LocationModel model = new LocationModel();
			model.setId(id);
			Boolean check = adminService.deleteLocation(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Location Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Location Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Location Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	// =================for Categpry module
	// ===========================================================

	

	@PostMapping(value = "/save_category", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveCategory(@RequestBody CategoryModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveCategory(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Category Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Category Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_category", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteCategory(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			CategoryModel model = new CategoryModel();
			model.setId(id);
			Boolean check = adminService.deleteCategory(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Category Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Category Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Category Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	// =================for Sub Categpry module
	// ===========================================================

	

	@PostMapping(value = "/save_sub_category", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveSubCategory(@RequestBody SubCategoryModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveSubCategory(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Sub  Category Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Sub Category Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_sub_category", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteSubCategory(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			SubCategoryModel model = new SubCategoryModel();
			model.setId(id);
			Boolean check = adminService.deleteSubCategory(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Category Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Category Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Category Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	// =================for Item module
	// ===========================================================

	

	@PostMapping(value = "/save_item", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveCategory(@RequestBody ItemModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveItem(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Category Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Category Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_item", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteItem(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			ItemModel model = new ItemModel();
			model.setId(id);
			Boolean check = adminService.deleteItem(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Category Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Category Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Category Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	// =================for Blog Type module
	// ===========================================================

	

	@PostMapping(value = "/save_blog_type", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveBlogType(@RequestBody BlogTypeModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveBlogType(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Blog Type Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Blog Type Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_blog_type", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteBlogType(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			BlogTypeModel model = new BlogTypeModel();
			model.setId(id);
			Boolean check = adminService.deleteBlogType(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Blog Type Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Blog Type Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Blog Type Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	// =================for Blog Type module
	// ===========================================================

	

	@PostMapping(value = "/save_query_type", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveQueryType(@RequestBody QueryTypeModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean check = adminService.saveQueryType(model);
		if (check == true) {
			response.put("response_message", "Successfully Save Query Type Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Save Query Type Detail !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	@GetMapping(value = "/delete_query_type", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> deleteQueryType(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (id != null && id > 0) {
			QueryTypeModel model = new QueryTypeModel();
			model.setId(id);
			Boolean check = adminService.deleteQueryType(model);
			if (check == true) {
				response.put("response_message", "Successfully Save Blog Type Detail");
				response.put("response_status", true);
			} else {
				response.put("response_message", "Not Save Blog Type Detail !!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "Blog Type Detail Data is not Correct !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
}
