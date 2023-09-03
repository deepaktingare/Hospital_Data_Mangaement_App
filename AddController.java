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

import com.DeepakTingare.spring_boot_hospital_app.Service.AddressService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Address;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@RestController
public class AddController {
	
	@Autowired
	private AddressService service;

	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}
	
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @RequestParam int id,
			@RequestBody Address address) {
		return service.updateAddress(id, address);
	}

	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam int id) {
		return service.deleteAddress(id);
	}
   
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@Valid @RequestParam int id) {
		return service.getAddressById(id);
	}
}
