package com.raghav.lnt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="location")
public class LocationEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String locationName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cityId")
	private CityEntity cityEntity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public CityEntity getCityEntity() {
		return cityEntity;
	}
	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}
	
}
