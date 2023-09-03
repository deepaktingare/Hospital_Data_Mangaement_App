package com.DeepakTingare.spring_boot_hospital_app.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DeepakTingare.spring_boot_hospital_app.dto.Branch;
import com.DeepakTingare.spring_boot_hospital_app.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
	
	@Query("SELECT b FROM Branch b WHERE b.hospital=?1")
	public List<Branch> findBranchByHospital(Hospital hospital);
}
