package com.ElectricityBillSystem;

import java.sql.*;

public class JDBC_Connection {
	static final String DB_URL = "jdbc:mysql://localhost:3306/electricitybillsystem";
	static final String USER = "root";
	static final String PASS = "12345";
	
	public static Connection getconnection() throws SQLException {
		return DriverManager.getConnection(DB_URL,USER,PASS);
	}
}
