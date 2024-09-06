package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trainees {
	@Id
	private String trainees_id;
	private String trainees_name;
	
	@ManyToOne
	private Trainer tt;

	public String getTrainees_id() {
		return trainees_id;
	}

	public void setTrainees_id(String trainees_id) {
		this.trainees_id = trainees_id;
	}

	public String getTrainees_name() {
		return trainees_name;
	}

	public void setTrainees_name(String trainees_name) {
		this.trainees_name = trainees_name;
	}

	public Trainer getTt() {
		return tt;
	}

	public void setTt(Trainer tt) {
		this.tt = tt;
	}
	
	
}
