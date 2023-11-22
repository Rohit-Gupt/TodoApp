package com.mydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mydata.model.UserLogin;
import com.mydata.util.CreateConnection;

public class UserLoginDaoImpl implements UserLoginDao{
	Connection con = CreateConnection.initConnection();

	@Override
	public String validUser(UserLogin ul) {
		String res = null;
		String entUser = ul.getUsername();
		String entPass = ul.getPassword();
		String dbPass = null;
		try
		{
			PreparedStatement ps = con.prepareStatement("select password from user where username=?");
		    ps.setString(1, entUser);
		    ResultSet rs = ps.executeQuery();
	        while(rs.next()) {
	        	dbPass = rs.getString("password");
	        	System.out.println("in daoImpl dbpass"+dbPass);
	        }
	        con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if(entPass.equals(dbPass)) {
			res="valid";
		}
		else {
			res="invalid";
		}
		return res;
	}

}
