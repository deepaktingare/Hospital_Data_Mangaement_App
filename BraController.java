package com.DeepakTingare.spring_boot_hospital_app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeepakTingare.spring_boot_hospital_app.Service.AddressService;
import com.DeepakTingare.spring_boot_hospital_app.Service.BranchService;
import com.DeepakTingare.spring_boot_hospital_app.Service.HospitalService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Branch;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
public class BraController {

	@Autowired
	private BranchService service;

	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid, @RequestParam int aid) {
		return service.saveBranch(branch, hid, aid);
	}

	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid @RequestParam int id, @RequestBody Branch branch) {
		return service.updateBranch(id, branch);
	}
	
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@Valid @RequestParam int id) {
		return service.deleteBranch(id);
	}

	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@Valid @RequestParam int id) {
		return service.getBranchById(id);
	}

	@GetMapping("/branch/{hid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(@Valid @PathVariable int hid) {
		return service.getBranchByHospitalId(hid);
	}
}
