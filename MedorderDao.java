package com.DeepakTingare.spring_boot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DeepakTingare.spring_boot_hospital_app.Repo.MedorderRepo;
import com.DeepakTingare.spring_boot_hospital_app.dto.Encounter;
import com.DeepakTingare.spring_boot_hospital_app.dto.Medorder;

@Repository
public class MedorderDao {

	@Autowired
	private MedorderRepo repo;
	@Autowired
	private EncounterDao dao;

	public Medorder saveMedorder(Medorder medorder, int eid) {
		Encounter encounter = dao.getEncounterById(eid);
		medorder.setEncounter(encounter);
		return repo.save(medorder);
	}

	public Medorder updateMedorder(int id, Medorder medorder) {
		if (repo.findById(id).isPresent()) {
			medorder.setId(id);
			return repo.save(medorder);
		} else {
			return null;
		}
	}

	public Medorder getMedorderById(int id) {
		return repo.findById(id).get();
	}

	public Medorder deleteMedorder(int id) {
		if (repo.findById(id).isPresent()) {
			Medorder medorder = repo.findById(id).get();
			repo.deleteById(id);
			return medorder;
		} else {
			return null;
		}
	}
}
