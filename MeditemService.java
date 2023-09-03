package com.DeepakTingare.spring_boot_hospital_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DeepakTingare.spring_boot_hospital_app.dao.MedItemDao;
import com.DeepakTingare.spring_boot_hospital_app.dto.Meditem;
import com.DeepakTingare.spring_boot_hospital_app.exception.IdNotFoundException;
import com.DeepakTingare.spring_boot_hospital_app.util.ResponseStructure;

@Service
public class MeditemService {

	@Autowired
	private MedItemDao dao;

	public ResponseEntity<ResponseStructure<Meditem>> saveMeditem(Meditem meditem, int mid) {
		ResponseStructure<Meditem> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMeditem(meditem, mid));
		return new ResponseEntity<ResponseStructure<Meditem>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Meditem>> updateMeditem(int id, Meditem meditem) {
		Meditem dbMeditem = dao.getMeditemById(id);
		meditem.setMedorder(dbMeditem.getMedorder());
		Meditem daoMeditem = dao.updateMeditem(id, meditem);
		if (daoMeditem != null) {
			ResponseStructure<Meditem> structure = new ResponseStructure<>();
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoMeditem);
			return new ResponseEntity<ResponseStructure<Meditem>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}

	public ResponseEntity<ResponseStructure<Meditem>> getMeditemById(int id) {
		Meditem meditem = dao.getMeditemById(id);
		if (meditem != null) {
			ResponseStructure<Meditem> structure = new ResponseStructure<>();
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(meditem);
			return new ResponseEntity<ResponseStructure<Meditem>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}

	public ResponseEntity<ResponseStructure<Meditem>> deleteMeditem(int id) {
		Meditem meditem = dao.deleteMeditem(id);
		if (meditem != null) {
			ResponseStructure<Meditem> structure = new ResponseStructure<>();
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(meditem);
			return new ResponseEntity<ResponseStructure<Meditem>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}
}
