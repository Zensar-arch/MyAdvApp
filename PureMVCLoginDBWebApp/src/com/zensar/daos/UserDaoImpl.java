package com.zensar.daos;
/**
 * @author Susmita Basak
 *@version 1.0
 *@creation_date 21/09/2019 5:36pm
 *@modification_date 23/09/2019 
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description It is Data Access Object Interface Implementor Class.It is used in Persistence Layer of Application.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.entities.User;

public class UserDaoImpl implements UserDao  {
	private Connection con;
	
	public void setConnection(Connection con)
	{
		this.con=con;
	}
	@Override
	public void insert(User user)throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="Insert into User_login values(?,?)";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, user.getUsername());
		p.setString(2, user.getPassword());
		int insertcount=p.executeUpdate();
		if(insertcount>0) {
			System.out.println("New user is inserted");
		}
		else {
			System.out.println("Sorry! new user could not be inserted");
		}
	}

	@Override
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update from User_Login set password=? where username=?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, user.getPassword());
		p.setString(2, user.getUsername());
		
		int updatecount=p.executeUpdate();
		if(updatecount>0) {
			System.out.println("user record is updated successfully");
		}
		else {
			System.out.println("Sorry!user could not be updated");
		}

	}

	@Override
	public void delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from User_login where username=?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, user.getUsername());
		
		int deletecount=p.executeUpdate();
		if(deletecount>0) {
			System.out.println("User record is deleted successfully ");
		}
		else {
			System.out.println("Sorry!user record could not be deleted");
		}


	}

	@Override
	public User getByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="select username,password from user_login where username =?";
		PreparedStatement p= con.prepareStatement(sql);
		p.setString(1, username);
		ResultSet rs =p.executeQuery();
		if(rs.next()) {
			User user =new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}
		else {
		return null;
	}
	}

	@Override
	public List<User> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select username ,password from User_Login";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		return users;
	}

}
