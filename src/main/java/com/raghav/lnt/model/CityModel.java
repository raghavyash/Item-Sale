package com.raghav.lnt.model;

import javax.persistence.Column;

public class CityModel {
	private Long id;
	private String cityName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
	
}
