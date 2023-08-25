package com.ElectricityBillSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bill_Functions {

public void createbill() {
		
		String query1 = "SELECT c_type from consumer where c_id = ?";
		String query2 = "insert into bill (b_c_id,b_units,b_amt) values (?, ?, ?)";
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Consumer Id");
		int bcid=sc.nextInt();
		System.out.println("Enter Units Consumed");
		int bunits =sc.nextInt();
		String ctype = "";
		
		try(Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query1)) 
		{
			{
			ps.setInt(1, bcid);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
                ctype = rs.getString("c_type");
            } else {
            	System.out.println("");
                System.out.println("Consumer not found.");
            }
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query2)) 
		{
			{
				int bamt=0;
				if(ctype.equalsIgnoreCase("residential") )
					bamt=(bunits*10);
				else if(ctype.equalsIgnoreCase("commercial") )
					bamt=(bunits*20);	
				else
					bamt=(bunits*20);
				
				ps.setInt (1, bcid);
				ps.setInt (2, bunits);
				ps.setInt(3, bamt);
				
				ps.executeUpdate();
				System.out.println("");
				System.out.println("New Bill Generated");
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query3 = "SELECT b_id,b_amt FROM bill where b_c_id = ? AND b_units = ?";
		
		try(Connection conn = JDBC_Connection.getconnection();
				PreparedStatement ps = conn.prepareStatement(query3)) 
		{
			{
				ps.setInt(1, bcid);
				ps.setInt(2, bunits);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println("Bill ID: " + rs.getInt("b_id"));
					System.out.println("Bill Amount: " + rs.getFloat("b_amt"));
				}
			} 
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}

	
	}

public void updatebill() {
	
	boolean flag=true;
	while(flag)
	{
		
	String query = "SELECT * FROM bill";
		
	try (Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
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
	String query1 = "SELECT c_type from consumer where c_id = ?";
	String query2 = "UPDATE bill set b_c_id=?,b_units=?,b_amt=? where b_id=?";
	Scanner sc= new Scanner(System.in);
	
	System.out.println("Enter Bill ID to Update: ");
	int bid= sc.nextInt();
	System.out.println("");
	System.out.println("Enter Consumer Id: ");
	int bcid=sc.nextInt();
	System.out.println("Enter Units Consumed: ");
	int bunits =sc.nextInt();
	String ctype = "";
	
	
	try(Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query1)) 
	{
		{
		ps.setInt(1, bcid);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
            ctype = rs.getString("c_type");
        } else {
            System.out.println("Consumer not found.");
        }
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	try(Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query2)) 
	{
		{
			
			int bamt=0;
			if(ctype.equalsIgnoreCase("residential") )
				bamt=(bunits*10);
			else if(ctype.equalsIgnoreCase("commercial") )
				bamt=(bunits*20);
			else
				bamt=(bunits*20);
			
			ps.setInt (1, bcid);
			ps.setInt (2, bunits);
			ps.setInt(3, bamt);
			ps.setInt (4, bid);
			
			int row = ps.executeUpdate();
			if(row == 1)
			{
				System.out.println("");
				System.out.println("Bill "+ bid+ " Updated");
			}
			else
			{
				System.out.println("");
				System.out.println("No Bill With Bill ID "+bid);
			}
		} 
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	String query3 = "SELECT b_amt FROM bill where b_id = ?";
	
	try(Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query3)) 
	{
		{
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Updated Bill Amount: " + rs.getFloat("b_amt"));
			}
		} 
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}
	flag = false;
}
}
public void delbill() {
	
	boolean flag=true;
	while(flag)
	{
		Scanner sc = new Scanner(System.in);
		String query = "Delete FROM bill where b_id = ?";
		String query1 = "SELECT * FROM bill";
		
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
				System.out.println("Enter the Bill ID to Delete: ");
				int bid=sc.nextInt();
				ps.setInt(1, bid);
				
				int row = ps.executeUpdate();
				if(row==1) 
				{
					System.out.println("");
					System.out.println("Bill Deleted");
				}
				else
				{
					System.out.println("");
					System.out.println("No Bill With Bill ID "+bid);
				}
			} 
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		flag = false;
		}
	}
public void dispbill() {
	
	Scanner sc = new Scanner(System.in);
	String query = "SELECT * FROM bill where b_id = ?";
	
	try(Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query)) 
	{
		{
			
			System.out.println("Enter the Bill ID: ");
			int bid=sc.nextInt();
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				System.out.println("");
				System.out.println("Displaying Bill "+ bid +" Details...");
				System.out.println("--------------------------------------------------------");
			    System.out.printf("| %-7s | %-10s | %-10s | %-10s |\n", "BILL_ID", "CONSUMER_ID", "UNITS_CONSUMED", "BILL_AMOUNT");
			    System.out.println("--------------------------------------------------------");
			    
				//while(rs.next()) {
				//	System.out.println("Bill ID: " + rs.getInt("b_id"));
				//	System.out.println("Consumer ID:  " + rs.getInt("b_c_id"));
				//	System.out.println("Units Consumed: " + rs.getFloat("b_units"));
				//	System.out.println("Bill Amount: " + rs.getFloat("b_amt"));
				//}
			
					int bi = rs.getInt("b_id");
		            int ci =  rs.getInt("b_c_id");
		            int u = rs.getInt("b_units");
		            int a =  rs.getInt("b_amt");

		            printTableRow(bi ,ci, u, a); 
			            
			    System.out.println("--------------------------------------------------------");
			}
			else
			{
				System.out.println("");
				System.out.println("No Bill With Bill ID "+bid);
			}
			
			
			
		} 
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}

}


public void dispallbill() {
	
	
	String query = "SELECT * FROM bill";
	
	try(Connection conn = JDBC_Connection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery()) {;
		{
			System.out.println("");
			System.out.println("Displaying All Bill Details...");
			System.out.println("--------------------------------------------------------");
		    System.out.printf("| %-7s | %-10s | %-10s | %-10s |\n", "BILL_ID", "CONSUMER_ID", "UNITS_CONSUMED", "BILL_AMOUNT");
		    System.out.println("--------------------------------------------------------");
			
		    //while(rs.next()) {
			//	System.out.println("Bill ID: " + rs.getInt("b_id"));
			//	System.out.println("Consumer ID:  " + rs.getInt("b_c_id"));
			//	System.out.println("Units Consumed: " + rs.getFloat("b_units"));
			//	System.out.println("Bill Amount: " + rs.getFloat("b_amt"));
			//}
		    while (rs.next()) 
		    {
		    	int bi = rs.getInt("b_id");
	            int ci =  rs.getInt("b_c_id");
	            int u = rs.getInt("b_units");
	            int a =  rs.getInt("b_amt");

	            printTableRow(bi ,ci, u, a); 
	            
			}
		    System.out.println("--------------------------------------------------------");
		} 
	}catch (SQLException e) {
		//e.printStackTrace();
		System.out.println(e);
	}

}

public void printTableRow(int bi, int ci, int u, int a) {
	// TODO Auto-generated method stub
	System.out.printf("| %-7s | %-11s | %-14s | %-11s |\n", bi, ci, u, a);
}
}
