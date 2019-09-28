package com.zensar.services;

/**
 * @author Susmita Basak
 *@version 2.0
 *@creation_date 21/09/2019 5:23pm
 *@modification_date 28/09/2019 11:47pm
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description Java Bean Class used to represent database entity.It is also used for value object.
 * business layer
 */

import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

public class UserServiceImpl implements UserService {
	private UserDao userdao;

	public void setUserDao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		userdao.insert(user);

		// throw new ServiceException(e.getMessage());

	}

	@Override
	public void updateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		userdao.update(user);

		// throw new ServiceException(e.getMessage());}
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		userdao.delete(user);

		// throw new ServiceException(e.getMessage());
	}

	@Override
	public User findUserByName(String username) throws ServiceException {
		// TODO Auto-generated method stub

		User user = userdao.getByUsername(username);
		return user;
		// return null;

	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub

		return userdao.getAll();

	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		User dbUser = findUserByName(user.getUsername());

		if (dbUser != null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
			return false;
	}
}
