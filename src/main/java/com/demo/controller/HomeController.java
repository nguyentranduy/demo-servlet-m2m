package com.demo.controller;

import java.io.IOException;
import java.util.Objects;

import com.demo.model.Users;
import com.demo.service.UsersService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login", "/login-submit"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 773848495472151884L;
	
	private UsersService usersService = new UsersService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		String url = req.getServletPath();
		if (url.equals("/login")) {
			requestDispatcher = doGetViewLogin(requestDispatcher, req);
		} else if (url.equals("/login-submit")) {
			requestDispatcher = doSubmitLogin(requestDispatcher, req);
		}
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		String url = req.getServletPath();
		if (url.equals("/login-submit")) {
			requestDispatcher = doSubmitLogin(requestDispatcher, req);
		}
		requestDispatcher.forward(req, resp);
	}
	
	private RequestDispatcher doGetViewLogin(RequestDispatcher requestDispatcher, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Users currentUser = (Users) session.getAttribute("CURRENT_USER");
		
		if (Objects.isNull(currentUser)) {
			return req.getRequestDispatcher("/views/login.jsp");
		}
		
		return req.getRequestDispatcher("/views/demo.jsp");
	}
	
	private RequestDispatcher doSubmitLogin(RequestDispatcher requestDispatcher, HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			Users user = usersService.doLogin(username, password);
			HttpSession session = req.getSession();
			session.setAttribute("CURRENT_USER", user);
			return req.getRequestDispatcher("/views/demo.jsp");
		} catch (Exception e) {
			return req.getRequestDispatcher("/views/login.jsp");
		}
	}
}
