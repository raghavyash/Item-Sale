package com.raghav.lnt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.raghav.lnt.model.BlogModel;
import com.raghav.lnt.model.SaleModel;
import com.raghav.lnt.model.SearchSaleDTO;
import com.raghav.lnt.service.SaleService;

@RestController
@RequestMapping(value = { "/sale" })
public class SaleController {
	@Autowired
	SaleService saleService;

	@PostMapping(value = "/save-sale", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveSale(@RequestBody SaleModel model) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (model != null) {
			SaleModel model2 = saleService.saveSale(model);
			if (model2 != null) {
				response.put("response_data", model2);
				response.put("response_message", "Successfully Register User");
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
	@PostMapping(value = "/searchItemDetailList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> searchItemDetailList(@RequestBody SearchSaleDTO dto) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (dto != null) {
			List<SaleModel> model2 = saleService.searchSaleDetailList(dto);
			if (model2 != null) {
				response.put("response_data", model2);
				response.put("response_message", "Successfully Register User");
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
	
	@GetMapping(value = "/getSaleDetail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getSaleDetail(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		SaleModel model = saleService.getSaleDetailById(id);
		List<SaleModel> userPostSalelist=	null;
				if (model != null) {
			if(model.getUserId()!= null){
             System.out.println(" user id"+model.getUserId()+" id "+id );	
			userPostSalelist=	saleService.getSaleDetailListByUserId(model.getUserId());
			}
			response.put("response_data", model);
			response.put("response_data1", userPostSalelist);
			response.put("response_message", "User Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available User Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}
	@GetMapping(value = "/getSaleDetailListByItemId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getSaleDetailListByItemId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<SaleModel> list = saleService.getSaleDetailListByItemId(id);
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
	@GetMapping(value = "/getSaleListByUserId", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getSaleListByUserId(@RequestParam Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<SaleModel> model = saleService.getSaleDetailListByUserId(id);
		if (model != null) {
			response.put("response_data", model);
			response.put("response_message", "Sale Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Sale Detail List !!!!!");
			response.put("response_status", false);
		}
		return response;

	}

	
	@RequestMapping(value = "/uploadMultiFiles", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> uploadFileMulti(@ModelAttribute SaleModel files) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		String	result = saleService.upLoadImages(files);
		if(result!= null){
		response.put("response_data", result);
		response.put("response_message", "Upload Image Succesfully");
		response.put("response_status", true);
		}else{
			response.put("response_message", "Not Upload Image Succesfully");
			response.put("response_status", false);
		}
		return response;
	}


	@GetMapping("/getImagesBySaleId")
	public List<SaleModel> getListFiles(@RequestParam Long id) {
		List<SaleModel> model = null;
		if (id != null && id > 0) {
			model = saleService.getUpLoadImagesListBySaleId(id);
		}
		return model;
	}
	@GetMapping(value = "/getTotalCountItemDetailList", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getTotalItemDetailList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<SaleModel> model = saleService.getCountTotalItem();
		if(model!= null){
			response.put("response_data", model);
			
			response.put("response_message", "Total Count Item Detail List");
			response.put("response_status", true);
		} else {
			response.put("response_message", "Total Count Item Detail List");
			response.put("response_status", false);
		}
		return response;

	}
	
}
