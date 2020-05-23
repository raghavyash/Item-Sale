package com.raghav.lnt.model;


public class SearchSaleDTO {
	private Long categoryId;
	private Long subCategoryId;
	private Long itemId;
	private String cityName;
	private String locationName;
	private Double price;
	private String model;
	private String fuelType;
	private String kmDriven;
	private Integer year;
	private Integer pageNumber;
	private Integer pageSize;
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getKmDriven() {
		return kmDriven;
	}
	public void setKmDriven(String kmDriven) {
		this.kmDriven = kmDriven;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
