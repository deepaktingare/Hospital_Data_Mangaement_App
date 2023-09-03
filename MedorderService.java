package com.DeepakTingare.spring_boot_hospital_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DeepakTingare.spring_boot_hospital_app.dao.MedorderDao;
import com.DeepakTingare.spring_boot_hospital_app.dto.Medorder;
import com.DeepakTingare.spring_boot_hospital_app.exception.IdNotFoundException;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@Service
public class MedorderService {

	@Autowired
	private MedorderDao dao;

	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(Medorder medorder, int eid) {
		ResponseStructure<Medorder> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedorder(medorder, eid));
		return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(int id, Medorder medorder) {
		Medorder dbMedorder = dao.getMedorderById(id);
		medorder.setEncounter(dbMedorder.getEncounter());
		Medorder daoMedorder = dao.updateMedorder(id, medorder);
		ResponseStructure<Medorder> structure = new ResponseStructure<>();
		structure.setMessage("Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(daoMedorder);
		return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(int id) {
		Medorder medorder = dao.getMedorderById(id);
		if (medorder != null) {
			ResponseStructure<Medorder> structure = new ResponseStructure<>();
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not found for MedOrder");
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int id) {
		Medorder medorder = dao.deleteMedorder(id);
		if (medorder != null) {
			ResponseStructure<Medorder> structure = new ResponseStructure<>();
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Med Order");
		}
	}
}
