package com.zensar.daos;

/**
 * @author Susmita Basak
 *@version 2.0
 *@creation_date 21/09/2019 5:36pm
 *@modification_date 28/09/2019 11:12
 *@copyright Zensar Technologies,India. All rights reserved.
 *@Description It is Data Access Object Interface Implementor Class.It is used in Persistence Layer of Application.
 */

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

public class UserDaoImpl implements UserDao {
	private Session session;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		Configuration c = new Configuration().configure();
		SessionFactory f = c.buildSessionFactory();
		session = f.openSession();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Transaction t=session.beginTransaction();
		session.save(user);
		t.commit();

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction t =session.beginTransaction();
		session.update(user);
		t.commit();

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Transaction t =session.beginTransaction();
		session.delete(user);
		t.commit();

	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		
		return session.get(User.class,username);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q = session.createQuery("From User");
		return q.getResultList();
	}
}
