package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * @author Susmita Basak
 * @creation_date 27th Sept 2019 11.48am
 * @modification_date 25th sept 2019 11.48am
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved
 * @description It is a persistent Class.
 *  It is a WageEmp Bean Class.
 *
 */
@Entity
public class WageEmp extends Employee {
	private int hours;
	private float rate;
	
	
	public WageEmp() {
		// TODO Auto-generated constructor stub
	}


	public WageEmp(int empId, String name, LocalDate joinDate, double salary, int hours, float rate) {
		super(empId, name, joinDate, salary);
		this.hours = hours;
		this.rate = rate;
	}

	

	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "WageEmp [hours=" + hours + ", rate=" + rate + "]";
	}
	
	
	

}
