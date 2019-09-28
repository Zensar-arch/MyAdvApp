package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Susmita Basak
 *@version 2.0
 *@creation_date 21/09/2019 5:23pm
 *@modification_date 28/09/2019 11:23pm
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description Java Bean Class used to represent database entity.It is also used for value object.
 * It is used in all layers of application.
 */
@Entity
@Table(name = "User_login")
public class User {
	@Id
	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
