package com.zensar.services;

import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

public class UserServiceImpl implements UserService {
	private UserDao userdao;
	

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		
		try {
			userdao.insert(user);
		}
		catch(Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void updateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
		userdao.update(user);}
		catch(Exception e) {
		throw new ServiceException(e.getMessage());}
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
		userdao.delete(user);}
		catch(Exception e) {
		throw new ServiceException(e.getMessage());}
	}

	@Override
	public User findUserByName(String username) throws ServiceException {
		// TODO Auto-generated method stub
		try {
		User user = userdao.getByUsername(username);
		return user;}
		//return null;
		catch(Exception e) {
		throw new ServiceException(e.getMessage());}
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		try {
		userdao.getAll();}
		catch(Exception e) {
		
		throw new ServiceException(e.getMessage());}
		return null;
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		User dbUser = findUserByName(user.getUsername());
		
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()))
				return true;
		else
			return false;
	}
}
	