package com.DeepakTingare.spring_boot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeepakTingare.spring_boot_hospital_app.Service.PersonService;
import com.DeepakTingare.spring_boot_hospital_app.dto.Person;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@RestController
public class PersController {

	@Autowired
	private PersonService service;

//	@ApiOperation(value = "Save Person", notes = "Api is used to save person")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved") })

	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

//	@ApiOperation(value = "Update Person", notes = "Api is used to update person using person_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
//			@ApiResponse(code = 404, message = "Id not found for person") })

	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

//	@ApiOperation(value = "Delete Person", notes = "Api is used to delete person using person_id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
//			@ApiResponse(code = 404, message = "Id not found for person") })

	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

//	@ApiOperation(value = "Get Person By Id", notes = "Api is used to fetch person using person_id")
//	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
//			@ApiResponse(code = 404, message = "Id not found for person") })

	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getPerson(@RequestParam int id) {
		return service.getPersonById(id);
	}
}
