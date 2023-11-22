package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mydata.model.Todo;
import com.mydata.util.CreateConnection;

public class TodoDalmpl implements TodoDao {
	Connection con = CreateConnection.initConnection();

	@Override
	public List<Todo> viewAllTodo() {
		List<Todo> all =new ArrayList<Todo>();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from todo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Todo t = new Todo();
				t.setTitle(rs.getString(1));
				t.setTargetDate(rs.getDate(2));
				t.setStatus(rs.getString(3));
				
				all.add(t);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return all;
	}

	@Override
	public int saveTodo(Todo t) {
		int x=0;
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into todo value(?,?,?)");
			ps.setString(1, t.getTitle());
			ps.setDate(2, t.getTargetDate());
			ps.setString(3, t.getStatus());
			x=ps.executeUpdate();
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public String deleteTodo(String s) {
		try
		{
			PreparedStatement ps = con.prepareStatement("delete from todo where title=?");
			ps.setString(1, s);
			int x = ps.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public Todo viewTodoByTitle(String s) {
		Todo t = new Todo();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from todo where title=?");
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t.setTitle(rs.getString(1));
				t.setTargetDate(rs.getDate(2));
				t.setStatus(rs.getString(3));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return t;
	}

	@Override
	public String update(String s, String s1) {
	    String res = "Success"; 

	    try {
	    	PreparedStatement ps = con.prepareStatement("update todo set status=? where title=?");
	    	ps.setString(1, s1); 
	    	ps.setString(2, s); 
	    	int x = ps.executeUpdate(); 
	        if (x > 0) {
	            res = "Update successful";
	        } else {
	            res = "Update failed1"; 
	        }
	    } 
	    catch (Exception e) {
	        System.out.println(e);
	       
	    }

	    return res;
	}


}
