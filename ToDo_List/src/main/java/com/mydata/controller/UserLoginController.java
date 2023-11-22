package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserLoginDao;
import com.mydata.dao.UserLoginDaoImpl;
import com.mydata.model.UserLogin;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String u = request.getParameter("uname");
		String p = request.getParameter("pass");
		System.out.println("in Logincontroller u -"+u+"Pass="+p);
		
		UserLogin ul = new UserLogin(u, p);
		UserLoginDao dao = new UserLoginDaoImpl();
		String output = dao.validUser(ul);
		System.out.println("in Logincontroller output -"+output);
		if(output.equalsIgnoreCase("valid")) {
			request.getRequestDispatcher("TodoList.jsp").forward(request, response);
		}
		else {
			out.print("<b>Invalid Usrname or Password</b>");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
	}

}
