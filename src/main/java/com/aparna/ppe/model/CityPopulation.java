package com.aparna.ppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citypopulation") 
public class CityPopulation {

	@Id
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "population")
	private Long population;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}
	
}
