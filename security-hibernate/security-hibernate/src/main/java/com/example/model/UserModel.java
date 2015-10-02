package com.example.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.pojo.User;

@Repository
public class UserModel {

	private static SessionFactory sessionFactory;

	public static void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}

	public static User findByPrimaryKey(int id) {
		User user = new User(id);

		Session session = sessionFactory.getCurrentSession();

		Query hqlQuery = session.createQuery("from User where id = :id");
		@SuppressWarnings("unchecked")
		List<User> results = hqlQuery.setProperties(user).list();
		if (results.size() != 0)
			user = (User) results.get(0);
		else
			user = null;

		return user;
	}

	public static int create(User user) {
		int id = 0;

		Session session = sessionFactory.getCurrentSession();

		id = (Integer) session.save(user);

		return id;
	}

	public static void update(User user) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// TODO Saber si se guardo o no
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void delete(User user) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// TODO Saber si se guardo o no
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public static User findByUsername(String username) {
		User user = new User();
		user.setUsername(username);

		Session session = sessionFactory.getCurrentSession();

		Query hqlQuery = session.createQuery("from User where username = :username");
		@SuppressWarnings("unchecked")
		List<User> results = hqlQuery.setProperties(user).list();
		if (results.size() != 0)
			user = (User) results.get(0);
		else
			user = null;

		return user;
	}

}
