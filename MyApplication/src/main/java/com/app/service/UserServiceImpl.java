package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDAO;
import com.app.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User add(User p){
		System.out.println("in dao implemention");
		User addedUser = this.userDAO.add(p);
		return addedUser;
	}

	@Override
	@Transactional
	public User update(User p){
		User updatedUser = this.userDAO.update(p);
		return updatedUser;
	}

	@Override
	@Transactional
	public List<User> list() {
		return this.userDAO.list();
	}

	@Override
	@Transactional
	public User getById(int id) {
		return this.userDAO.getById(id);
	}

	@Override
	@Transactional
	public User remove(int id) {
		return this.userDAO.remove(id);
	}

}
