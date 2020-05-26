package com.aparna.ppe.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aparna.ppe.model.PPECityData;

public interface PPERepository extends JpaRepository<PPECityData, String>{
	

}
