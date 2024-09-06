package com.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	@Id
	private String trainer_id;
	private String trainer_name;
	
	@OneToMany(mappedBy = "tt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Trainees> tList;

	public String getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public List<Trainees> gettList() {
		return tList;
	}

	public void settList(List<Trainees> tList) {
		this.tList = tList;
	}
	
	
	
	
}















