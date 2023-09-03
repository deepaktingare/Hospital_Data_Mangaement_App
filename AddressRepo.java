package com.DeepakTingare.spring_boot_hospital_app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepakTingare.spring_boot_hospital_app.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	
	
}
