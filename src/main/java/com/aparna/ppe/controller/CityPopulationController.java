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
import com.aparna.ppe.model.CityPopulation;
import com.aparna.ppe.repository.CityPopulationRepository;

@RestController
@RequestMapping("/ppe_api/v1")
public class CityPopulationController {

	@Autowired
	CityPopulationRepository cityPopulationRepository;

	@GetMapping("/citypopulation")
	public List<CityPopulation> getAllData(Model model) {

		return cityPopulationRepository.findAll();

	}

	@PostMapping("/citypopulation")
	public CityPopulation addCity(@Valid @RequestBody CityPopulation CityPopulation) {

		return cityPopulationRepository.save(CityPopulation);

	}

	@GetMapping("/citypopulation/{cityName}")
	public ResponseEntity<CityPopulation> updateEmployee(@PathVariable(value = "cityName") String cityName)
			throws ResourceNotFoundException {
		CityPopulation pperecord = cityPopulationRepository.findById(cityName).orElseThrow(
				() -> new ResourceNotFoundException("City population Record not found for this id :: " + cityName));

		return ResponseEntity.ok(pperecord);

	}

	@DeleteMapping("/citypopulation/{city}")
	public Map<String, Boolean> deletedPPERecord(@PathVariable(value = "city") String city)
			throws ResourceNotFoundException {
		CityPopulation ppedata = cityPopulationRepository.findById(city).orElseThrow(
				() -> new ResourceNotFoundException("CITY Name Record not found for this city :: " + city));

		cityPopulationRepository.delete(ppedata);
		Map<String, Boolean> response = new HashMap<>();

		response.put("deleted city record", Boolean.TRUE);

		return response;

	}

}
