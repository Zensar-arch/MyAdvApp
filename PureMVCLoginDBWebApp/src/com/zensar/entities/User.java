package com.zensar.entities;


/**
 * @author Susmita Basak
 *@version 1.0
 *@creation_date 21/09/2019 5:23pm
 *@modification_date 21/09/2019 5:23pm
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description Java Bean Class used to represent database entity.It is also used for value object.
 * It is used in all layers of application.
 */
public class User {
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
