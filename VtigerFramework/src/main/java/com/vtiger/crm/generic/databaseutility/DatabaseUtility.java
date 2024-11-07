package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection conn;
	
	public void registerDbConnection() throws SQLException
	{
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		}
		catch(Exception e)
		{
			
		}
		
	}

	public void closeDbConnection() throws SQLException
	{
		conn.close();
		System.out.println("closed");
	}
	
	public ResultSet insertSelectStatement(String query) throws SQLException
	{
		ResultSet set=null;
		try{
		Statement state=conn.createStatement();
		set=state.executeQuery(query);
		
		
	}
	catch(Exception e) {

		
	}
		return set;
	}
	
	public int insertNonSelectStatement(String query) throws SQLException
	{
		Statement state=conn.createStatement();
		int set=state.executeUpdate(query);
		return set;
	}
	
}
