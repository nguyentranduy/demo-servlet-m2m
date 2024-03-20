package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Users;

public class UsersDao extends AbstractDao {

	public Users doLogin(String username, String password) throws Exception {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				return new Users(id, username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new Exception();
	}

	public List<Users> findAll() {
		List<Users> users = new ArrayList<>();

		String sql = "SELECT * FROM users WHERE isActived = 1";

		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Long id = rs.getLong("id");
				String username = rs.getString("username");
				Users user = new Users(id, username);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
}
