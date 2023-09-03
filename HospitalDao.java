package com.DeepakTingare.spring_boot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DeepakTingare.spring_boot_hospital_app.Repo.HospitalRepo;
import com.DeepakTingare.spring_boot_hospital_app.dto.Hospital;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo repo;

	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		if (repo.findById(id).isPresent()) {
			hospital.setId(id);
			return repo.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int id) {
		if (repo.findById(id).isPresent()) {
			Hospital hospital = repo.findById(id).get();
			repo.deleteById(id);
			return hospital;
		} else {
			return null;
		}
	}

	public Hospital getHospitalById(int id) {
		return repo.findById(id).get();
	}

	public List<Hospital> getAllHospitals() {
		return repo.findAll();
	}

	public Hospital getHospitalByEmail(String email) {
		return repo.findByEmail(email);
	}
}
