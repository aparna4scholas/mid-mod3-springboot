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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aparna.ppe.exception.ResourceNotFoundException;
import com.aparna.ppe.model.PPECityData;
import com.aparna.ppe.repository.PPERepository;


@RestController
@RequestMapping("/ppe_api/v1")
public class PPEController {

	@Autowired
	PPERepository dashboardRepository;
	
	  @GetMapping("/ppedata")
	  public List<PPECityData> getAllData(Model model) {
	  	
	  return this.dashboardRepository.findAll();
	  
	}
	  
	  @GetMapping("/dashboard")
	  public PPECityData dashboard(Model model) {
		List<PPECityData> allrecords =  this.dashboardRepository.findAll();
		int glovesTotal = 0;
		int masksTotal = 0;
		int surgicalGownCountTotal = 0;
		
		for(int i=0;i<allrecords.size();i++) {
			
			glovesTotal = glovesTotal + allrecords.get(i).getGlovesCount();
			masksTotal = masksTotal + allrecords.get(i).getMaskCount();
			surgicalGownCountTotal = surgicalGownCountTotal + allrecords.get(i).getSurgicalGownCount();
		}
		PPECityData  totalCount = new PPECityData();
		totalCount.setCityName("ALLCITIES");
		totalCount.setGlovesCount(glovesTotal);
		totalCount.setMaskCount(masksTotal);
		totalCount.setSurgicalGownCount(surgicalGownCountTotal);
	  	
	  return totalCount;
	  
	}

	  
	  
	  //  save record
	  
	  @PostMapping("/pperecords")
	  public PPECityData createPPERecord(@Valid @RequestBody PPECityData dashboard) {
		  dashboard.setUid(1L);
		  return dashboardRepository.save(dashboard);
	  }
	  
	  
	  @PutMapping("/pperecords/{cityName}")
	  public ResponseEntity<PPECityData> updateEmployee(@PathVariable(value = "cityName") String cityName,
			  @Valid @RequestBody PPECityData ppeDetails)
		      throws ResourceNotFoundException {
		  PPECityData pperecord = dashboardRepository.findById(cityName)
		    		  .orElseThrow(()-> new ResourceNotFoundException("PPE Record not found for this id :: " + cityName));
		      
		      
		     pperecord.setCityName(ppeDetails.getCityName()); 
		     pperecord.setMaskCount(ppeDetails.getMaskCount());
		     pperecord.setSurgicalGownCount(ppeDetails.getSurgicalGownCount());
		     
		     
		     final PPECityData updatedPPERecord = dashboardRepository.save(pperecord);
		     
		     
		     return ResponseEntity.ok(updatedPPERecord);
		      
		      }

	  @GetMapping("/pperecords/{cityName}")
	  public ResponseEntity<PPECityData> getPPERecord(@PathVariable(value = "cityName") String cityName)
		      throws ResourceNotFoundException {
		  PPECityData pperecord = dashboardRepository.findById(cityName)
		    		  .orElseThrow(()-> new ResourceNotFoundException("PPE Record not found for this id :: " + cityName));
		      
		     return ResponseEntity.ok(pperecord);
		      
		      }

	  
	  @DeleteMapping("/pperecords/{city}")
	  public Map<String, Boolean> deletedPPERecord(@PathVariable(value = "city") String city)
				      throws ResourceNotFoundException {
		  PPECityData ppedata = dashboardRepository.findById(city)
				    		  .orElseThrow(()-> new ResourceNotFoundException("PPE Record not found for this city :: " + city));
	  
		              dashboardRepository.delete(ppedata);
				      Map<String, Boolean> response = new HashMap<>();
				      
				      response.put("deleted ppe record", Boolean.TRUE);
				      
				      return response;
	  
	  }

	
}
