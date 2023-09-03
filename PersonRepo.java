package com.DeepakTingare.spring_boot_hospital_app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepakTingare.spring_boot_hospital_app.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
