package com.ElectricityBillSystem;

import java.sql.*;
import java.util.*;

public class Consumer_Functions{

	public void createcon() {
		String query = "insert into consumer values (?, ?, ?, ?)";
		Scanner sc= new Scanner(System.in);
		
		String query1 = "SELECT * FROM consumer";
		int i=1;
		try (Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query1);
				ResultSet rs = ps.executeQuery())
		{
			
		    while (rs.next()) 
		    {
		    	i = rs.getInt("c_id");
			} 
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		try(Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query)) 
		{
			{
				System.out.println("Enter Consumer Name: ");
				String cname=sc.nextLine();
				System.out.println("Enter Consumer Age: ");
				int cage =sc.nextInt();
				System.out.println("Enter Consumer Type(residential/commercial): ");
				String ctype = sc.next();
				ps.setInt (1, (i+1));
				ps.setString (2, cname);
				ps.setInt (3, cage);
				ps.setString (4, ctype);
				
				ps.executeUpdate();
				
				System.out.println("");
				System.out.println("New Consumer Created ");
				System.out.println("Consumer ID: "+(i+1));
			} 
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void updatecon() {
		
		boolean flag=true;
		while(flag)
		{
		String query = "UPDATE consumer set c_name=?,c_age=?,c_type=? where c_id=?";
		Scanner sc= new Scanner(System.in);
		
		
		String query1 = "SELECT * FROM consumer";
		
		try (Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query1);
				ResultSet rs = ps.executeQuery())
		{
			
		    if(rs.next() == false)
		    {
		    	System.out.println("No Consumer Records Are Inserted");
		    	System.out.println("Please Try After Inserting A Record");
		    	break;
		    }
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		try(Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query)) 
		{
			{
				System.out.println("Enter Consumer ID to Update: ");
				int cid= sc.nextInt();
				System.out.println("");
				sc.nextLine();
				System.out.println("Enter Consumer Name: ");
				String cname=sc.nextLine();
				System.out.println("Enter Consumer Age: ");
				int cage =sc.nextInt();
				System.out.println("Enter Consumer Type(residential/commercial): ");
				String ctype = sc.next();
				
				ps.setString (1, cname);
				ps.setInt (2, cage);
				ps.setString (3, ctype);
				ps.setInt (4, cid);
				
				int row = ps.executeUpdate();
				
				if(row == 1) 
				{
					System.out.println("");
					System.out.println("Consumer ID "+cid+" Updated");
				}
				else
				{
					System.out.println("");
					System.out.println("No Consumer With Consumer ID "+cid);
				}
				
			} 
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		flag=false;
	}
		
	}

public void delcon() {
	
	boolean flag=true;
	while(flag)
	{	
	Scanner sc = new Scanner(System.in);
	String query = "Delete FROM consumer where c_id = ?";
	
	String query1 = "SELECT * FROM consumer";
	
	try (Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query1);
			ResultSet rs = ps.executeQuery())
	{
		
	    if(rs.next() == false)
	    {
	    	System.out.println("No Consumer Records Are Inserted");
	    	System.out.println("Please Try After Inserting A Record");
	    	break;
	    }
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}
		
	try (Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query))
	{
		{
			System.out.println("Enter the Consumer ID to Delete: ");
			int cid=sc.nextInt();
			ps.setInt(1, cid);
			
			int row = ps.executeUpdate();
			
			if(row==1) 
			{
				System.out.println("");
				System.out.println("Consumer Deleted");
			}
			else
			{
				System.out.println("");
				System.out.println("No Consumer With Consumer ID "+cid);
			}
		} 
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}
		flag=false;
	}
}

	public void dispcon() {
	
	
	Scanner sc = new Scanner(System.in);
	String query = "SELECT * FROM consumer where c_id = ?";
		
	try (Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query))
	{
			System.out.print("Enter the Consumer ID: ");
			int cid=sc.nextInt();
			System.out.println("");
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Displaying Customer "+ cid +" Details...");
				System.out.println("--------------------------------------------------------------");
			    System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "CONSUMER_ID", "CONSUMER_NAME", "CONSUMER_AGE", "CONSUMER_TYPE");
			    System.out.println("--------------------------------------------------------------");
				
				//while(rs.next()) {
				//	System.out.println("Consumer ID: " + rs.getInt("c_id"));
				//	System.out.println("Name:  " + rs.getString("c_name"));
				//	System.out.println("Age: " + rs.getInt("c_age"));
				//	System.out.println("Consumer Type: " + rs.getString("c_type"));
				//}
			    
			    	int i = rs.getInt("c_id");
		            String n =  rs.getString("c_name");
		            int a = rs.getInt("c_age");
		            String t =  rs.getString("c_type");

		            printTableRow(i ,n, a, t);                
				 
			    System.out.println("--------------------------------------------------------------");
			}
			else
			{
				System.out.println("");
				System.out.println("No Consumer With Consumer ID "+cid);
			}
			
			
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}

	}


	public void dispallcon() {
	
		String query = "SELECT * FROM consumer";
		
		try (Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery())
		{
			System.out.println("");
			System.out.println("Displaying All Customer Details...");
			System.out.println("--------------------------------------------------------------");
			System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "CONSUMER_ID", "CONSUMER_NAME", "CONSUMER_AGE", "CONSUMER_TYPE");
			System.out.println("--------------------------------------------------------------");
			//while(rs.next()) {
			//	System.out.println("Consumer ID: " + rs.getInt("c_id"));
			//	System.out.println("Name:  " + rs.getString("c_name"));
			//	System.out.println("Age: " + rs.getInt("c_age"));
			//	System.out.println("Type: " + rs.getString("c_type"));
			//}
		    while (rs.next()) 
		    {
		    	int i = rs.getInt("c_id");
	            String n =  rs.getString("c_name");
	            int a = rs.getInt("c_age");
	            String t =  rs.getString("c_type");
	
	            printTableRow(i ,n, a, t); 
	            
			} 
		    System.out.println("--------------------------------------------------------------");
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
	
		}
	
	private void printTableRow(int i, String n, int a, String t) {
		// TODO Auto-generated method stub
		System.out.printf("| %-11s | %-13s | %-12s | %-13s |\n", i, n, a, t);
	}
}
