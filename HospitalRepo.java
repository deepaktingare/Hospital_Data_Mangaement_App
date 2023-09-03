package com.DeepakTingare.spring_boot_hospital_app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepakTingare.spring_boot_hospital_app.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	
	public Hospital findByEmail(String email);
}
