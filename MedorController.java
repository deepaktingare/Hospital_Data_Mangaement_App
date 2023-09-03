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

import com.DeepakTingare.spring_boot_hospital_app.Service.MedorderService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Medorder;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@RestController
public class MedorController {

	@Autowired
	private MedorderService service;

//	@ApiOperation(value = "Save MedOrder", notes = "Api is used to save medorder using encounter_id")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
//			@ApiResponse(code = 404, message = "Id not found for encounter") })

	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@Valid @RequestBody Medorder medorder,
			@RequestParam int eid) {
		return service.saveMedorder(medorder, eid);
	}

//	@ApiOperation(value = "Update MedOrder", notes = "Api is used to update medorder using medorder_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
//			@ApiResponse(code = 404, message = "Id not found for medorder") })

	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(@Valid @RequestParam int id,
			@RequestBody Medorder medorder) {
		return service.updateMedorder(id, medorder);
	}

//	@ApiOperation(value = "Get MedOrder By Id", notes = "Api is used to fetch medorder using medorder_id")
//	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
//			@ApiResponse(code = 404, message = "Id not found for medorder") })
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<Medorder>> getMedOrderById(@Valid @RequestParam int id) {
		return service.getMedorderById(id);
	}
//
//	@ApiOperation(value = "Delete MedOrder", notes = "Api is used to delete medorder using medorder_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
//			@ApiResponse(code = 404, message = "Id not found for medorder") })

	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(@Valid @RequestParam int id) {
		return service.deleteMedorder(id);
	}
}
