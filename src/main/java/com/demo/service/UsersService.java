package com.demo.service;

import java.util.List;

import com.demo.dao.UsersDao;
import com.demo.model.Users;

public class UsersService {
	
	private UsersDao dao = new UsersDao();

	public Users doLogin(String username, String password) throws Exception {
		return dao.doLogin(username, password);
	}
	
	public List<Users> findAll() {
		return dao.findAll();
	}
}

