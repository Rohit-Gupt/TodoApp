package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserRegisterDao;
import com.mydata.dao.UserRegisterDaoImpl;
import com.mydata.model.UserRegister;

/**
 * Servlet implementation class UserRegisterController
 */
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("fname");
		String l = request.getParameter("lname");
		String un = request.getParameter("user");
		String pd = request.getParameter("pwd");
		
		UserRegister ur = new UserRegister(n, l, n, pd);
		UserRegisterDao ud = new UserRegisterDaoImpl();
		int res=ud.saveUser(ur);
		if(res>0) {
			request.getRequestDispatcher("Login.html").forward(request, response);
		}
		else {
			out.print("<b> try again</b> ");
			request.getRequestDispatcher("Register.html").include(request, response);
		}
	}

}
