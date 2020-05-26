package com.aparna.ppe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aparna.ppe.exception.ResourceNotFoundException;
import com.aparna.ppe.model.CityName;
import com.aparna.ppe.repository.CityNameRepository;

@RestController
@RequestMapping("/ppe_api/v1")
public class CityNameController {
	
	@Autowired
	CityNameRepository cityNameRepository;

	@GetMapping("/citynames")
	  public List<CityName> getAllData(Model model) {
	  	
	  return cityNameRepository.findAll();
	  
	}

	@PostMapping("/citynames")
	  public CityName addCity(@Valid @RequestBody CityName cityName) {
	  	
	  return cityNameRepository.save(cityName);
	  
	}
	
	 @GetMapping("/citynames/{cityName}")
	  public ResponseEntity<CityName> updateEmployee(@PathVariable(value = "cityName") String cityName)
		      throws ResourceNotFoundException {
		 CityName pperecord = cityNameRepository.findById(cityName)
		    		  .orElseThrow(()-> new ResourceNotFoundException("City name Record not found for this id :: " + cityName));
		      
		     return ResponseEntity.ok(pperecord);
		      
		      }

	 
	 
	  @DeleteMapping("/citynames/{city}")
	  public Map<String, Boolean> deletedPPERecord(@PathVariable(value = "city") String city)
				      throws ResourceNotFoundException {
		  CityName ppedata = cityNameRepository.findById(city)
				    		  .orElseThrow(()-> new ResourceNotFoundException("CITY Name Record not found for this city :: " + city));
	  
		  cityNameRepository.delete(ppedata);
				      Map<String, Boolean> response = new HashMap<>();
				      
				      response.put("deleted city record", Boolean.TRUE);
				      
				      return response;
	  
	  }
	
}
