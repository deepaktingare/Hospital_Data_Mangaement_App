package com.DeepakTingare.spring_boot_hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeepakTingare.spring_boot_hospital_app.Service.HospitalService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Hospital;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
public class HosController {
	
	@Autowired
	private HospitalService service;


	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}


	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@Valid @RequestParam int id, @RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}

	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@Valid @RequestParam int id) {
		return service.deleteHospital(id);
	}

	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@Valid @RequestParam int id) {
		return service.getHospitalById(id);
	}
}
