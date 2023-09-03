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

import com.DeepakTingare.spring_boot_hospital_app.Service.MeditemService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Meditem;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@RestController
public class MedItController {

	@Autowired
	private MeditemService service;

//	@ApiOperation(value = "Save MedItems", notes = "Api is used to save meditems using medorder_id")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
//			@ApiResponse(code = 404, message = "Id not found for medorder") })

	@PostMapping("/meditem")
	public ResponseEntity<ResponseStructure<Meditem>> saveMeditem(@Valid @RequestBody Meditem meditem, @RequestParam int mid) {
		return service.saveMeditem(meditem, mid);
	}

//	@ApiOperation(value = "Update MedItems", notes = "Api is used to update meditems using meditems_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
//			@ApiResponse(code = 404, message = "Id not found for meditems") })

	@PutMapping("/meditem")
	public ResponseEntity<ResponseStructure<Meditem>> updateMeditem(@Valid @RequestParam int id,
			@RequestBody Meditem meditem) {
		return service.updateMeditem(id, meditem);
	}

//	@ApiOperation(value = "Delete MedItems", notes = "Api is used to delete meditems using meditems_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
//			@ApiResponse(code = 404, message = "Id not found for meditems") })

	@GetMapping("/meditem")
	public ResponseEntity<ResponseStructure<Meditem>> getMeditemById(@Valid @RequestParam int id) {
		return service.getMeditemById(id);
	}

//	@ApiOperation(value = "Get MedItems By Id", notes = "Api is used to fetch meditems using meditems_id")
//	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
//			@ApiResponse(code = 404, message = "Id not found for meditems") })

	@DeleteMapping("/meditem")
	public ResponseEntity<ResponseStructure<Meditem>> deleteMeditem(@Valid @RequestParam int id) {
		return service.deleteMeditem(id);
	}
}
