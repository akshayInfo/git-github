package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.User;


@Repository
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User add(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = (Integer) session.save(p);
		User savedUser = (User) session.get(User.class, id);		
		return savedUser;

	}

	@Override
	public User update(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		int id = (Integer) session.save(p);
		User savedUser = (User) session.get(User.class, id);		
		return savedUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();		
		return usersList;
	}

	@Override
	public User getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("dfdff");
		User p = (User) session.load(User.class, new Integer(id));
		System.out.println(p.getFirstname());
		User u = new User();
		u=p;
		return u;
	}

	@Override
	public User remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		User deletedUser = (User) session.get(User.class, id);
		return deletedUser;
	}

}
