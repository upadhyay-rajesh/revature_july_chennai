package com.revshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection getConnection()throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revaturechennai","root","root");
		return con;
	}

}
