package com.DeepakTingare.spring_boot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Meditem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "name can't be blank")
	private String name;
	
	private long cost;
	
	@ManyToOne
	private Medorder medorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public Medorder getMedorder() {
		return medorder;
	}

	public void setMedorder(Medorder medorder) {
		this.medorder = medorder;
	}

	@Override
	public String toString() {
		return "Meditem [id=" + id + ", name=" + name + ", cost=" + cost + ", medorder=" + medorder + "]";
	}
	
}
