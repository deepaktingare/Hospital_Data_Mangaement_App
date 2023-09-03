package com.DeepakTingare.spring_boot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DeepakTingare.spring_boot_hospital_app.Repo.MeditemRepo;
import com.DeepakTingare.spring_boot_hospital_app.dto.Meditem;
import com.DeepakTingare.spring_boot_hospital_app.dto.Medorder;

@Repository
public class MedItemDao {

	@Autowired
	private MeditemRepo repo;
	@Autowired
	private MedorderDao dao;

	public Meditem saveMeditem(Meditem meditem, int mid) {
		Medorder medorder = dao.getMedorderById(mid);
		meditem.setMedorder(medorder);
		return repo.save(meditem);
	}

	public Meditem updateMeditem(int id, Meditem meditem) {
		if (repo.findById(id).isPresent()) {
			meditem.setId(id);
			return repo.save(meditem);
		} else {
			return null;
		}
	}

	public Meditem getMeditemById(int id) {
		return repo.findById(id).get();
	}

	public Meditem deleteMeditem(int id) {
		if (repo.findById(id).isPresent()) {
			Meditem meditem = repo.findById(id).get();
			repo.deleteById(id);
			return meditem;
		} else {
			return null;
		}
	}
}
