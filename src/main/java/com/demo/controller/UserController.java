package com.demo.controller;

import java.io.IOException;
import java.util.List;

import com.demo.model.Users;
import com.demo.service.UsersService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/user"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 2868860712752918030L;
	
	private UsersService usersService = new UsersService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/users.jsp");
		List<Users> users = usersService.findAll();
		req.setAttribute("users", users);
		requestDispatcher.forward(req, resp);
	}
}
