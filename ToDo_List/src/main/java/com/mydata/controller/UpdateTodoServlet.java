package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.TodoDalmpl;
import com.mydata.dao.TodoDao;

/**
 * Servlet implementation class UpdateTodoServlet
 */
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String t = request.getParameter("title");
		String s = request.getParameter("status");
		
		TodoDao td = new TodoDalmpl();
		String res = td.update(t, s);
		System.out.println("res="+res);
		if(res!=null)
		{
			request.getRequestDispatcher("TodoList.jsp").forward(request, response);
		}
		else {
			out.print("<b>Pls try again!!!!</b>");
			request.getRequestDispatcher("updateTodo.jsp").include(request, response);
		}
	}

}
