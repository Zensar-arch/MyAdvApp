package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Susmita Basak
 * @creation_date 27/09/2019 15:04
 * @modification_date 27/9/2019 15:04
 * @version 1.0
 * @copyright all rights reserved for zensar.
 * @description It is a flag entity class
 *
 */
@Entity
public class Flag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flagId;
	private String flagName;
	private String description;
	@OneToOne(mappedBy = "flag")
	private Country country;
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	

}
