package com.raghav.lnt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sale")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class SaleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private CategoryEntity categoryEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryId")
	private SubCategoryEntity subCategoryEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemId")
	private ItemEntity itemEntity;
	
	@Column
	private String description;
	@Column
	private String image1;
	@Column
	private String image2;
	@Column
	private String image3;
	@Column
	private String image4;
	@Column
	private String image5;
	@Column
	private Double price;
	@Column
	private String model;
	@Column
	private String fuelType;
	@Column
	private String kmDriven;
	@Column
	private Integer year;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	@Column
	private String other;
	@Column
	private String mobile;
	@Column
	private String cityName;
	@Column
	private String locationName;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdAt;
	@Column
	private String createdBy;
	@Column
	private Integer status;
	@Column
	private String color;
	@Column
	private String registrationNumber;
	@Column
	private String noOfOwner;
	@Column
	private String conditionGrade;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getNoOfOwner() {
		return noOfOwner;
	}

	public void setNoOfOwner(String noOfOwner) {
		this.noOfOwner = noOfOwner;
	}

	

	public String getConditionGrade() {
		return conditionGrade;
	}

	public void setConditionGrade(String conditionGrade) {
		this.conditionGrade = conditionGrade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public SubCategoryEntity getSubCategoryEntity() {
		return subCategoryEntity;
	}

	public void setSubCategoryEntity(SubCategoryEntity subCategoryEntity) {
		this.subCategoryEntity = subCategoryEntity;
	}

	public ItemEntity getItemEntity() {
		return itemEntity;
	}

	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

}
