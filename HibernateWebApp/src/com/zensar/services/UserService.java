package com.zensar.services;

import java.util.List;

import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * @author Susmita Basak
 *@version 1.0
 *@creation_date 21/09/2019 5:59pm
 *@modification_date 21/09/2019 5:59pm
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description It is Business Service Interface.It is used in Business Layer of Application.
 */
public interface UserService {
 void addUser(User user)throws ServiceException;
 void updateUser(User user)throws ServiceException;
 void removeUser(User user)throws ServiceException;
  User findUserByName(String username)throws ServiceException;
  List<User>findAllUsers()throws ServiceException;
  
  
  
  boolean validateUser(User user)throws ServiceException;
}
