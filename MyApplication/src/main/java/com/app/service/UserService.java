package com.app.service;

import java.util.List;

import com.app.model.User;


public interface UserService {

	public User add(User p);

	public User update(User p);

	public List<User> list();

	public User getById(int id);

	public User remove(int id);

}
