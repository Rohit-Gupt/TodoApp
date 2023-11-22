package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.TodoDalmpl;
import com.mydata.dao.TodoDao;
import com.mydata.model.Todo;

/**
 * Servlet implementation class AddTodoServlet
 */
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    String s = request.getParameter("title");
		    String s1 = request.getParameter("status");
		    String dateString = request.getParameter("targetd");
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date targetDate = null;
		    try {
		        targetDate = new Date(sdf.parse(dateString).getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    out.print(" in addotodoservlet Title: " + s);
		    out.print("Date: " + targetDate);
		    out.print("Status: " + s1);


		    Todo t = new Todo(s, targetDate, s1);
		    TodoDao td = new TodoDalmpl();
		    int res = td.saveTodo(t);
		    

		    if (res > 0) {
		        request.getRequestDispatcher("TodoList.jsp").forward(request, response);
		    } else {
		        out.print("Please try again!!!!");
		        request.getRequestDispatcher("AddTodo.html").include(request, response);
		    }
		}


}
