package com.aparna.ppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citynames") 
public class CityName {
	
	@Id
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "cityDescription")
	private String cityDescription;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityDescription() {
		return cityDescription;
	}

	public void setCityDescription(String cityDescription) {
		this.cityDescription = cityDescription;
	}
	
	

}
