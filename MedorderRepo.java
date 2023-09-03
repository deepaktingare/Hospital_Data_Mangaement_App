package com.DeepakTingare.spring_boot_hospital_app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepakTingare.spring_boot_hospital_app.dto.Medorder;

public interface MedorderRepo extends JpaRepository<Medorder, Integer> {

	
}
