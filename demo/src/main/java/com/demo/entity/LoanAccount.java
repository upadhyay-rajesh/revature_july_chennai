package com.demo.entity;

import javax.persistence.Entity;

@Entity
public class LoanAccount extends Account{
	private String interestRate;
}
