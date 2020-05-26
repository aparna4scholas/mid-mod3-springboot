package com.aparna.ppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citydata") 
public class PPECityData {
	
	@Id
	@Column(name = "city")
	private String cityName;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "unique_id")
	private Long uid;

	@Column(name = "gloves_count")
	private int glovesCount;

	@Column(name = "mask_count")
	private int maskCount;

	@Column(name = "surgical_gown_count")
	private int surgicalGownCount;
	
	
	public PPECityData(String cityName, int glovesCount, int maskCount, int surgicalGownCount) {
		super();
		this.cityName = cityName;
		this.glovesCount = glovesCount;
		this.maskCount = maskCount;
		this.surgicalGownCount = surgicalGownCount;
	}
	
	public PPECityData() {
		
	}



	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

	public int getMaskCount() {
		return maskCount;
	}

	public void setMaskCount(int maskCount) {
		this.maskCount = maskCount;
	}

	public int getSurgicalGownCount() {
		return surgicalGownCount;
	}

	public void setSurgicalGownCount(int surgicalGownCount) {
		this.surgicalGownCount = surgicalGownCount;
	}

	public int getGlovesCount() {
		return glovesCount;
	}

	public void setGlovesCount(int glovesCount) {
		this.glovesCount = glovesCount;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	

}





