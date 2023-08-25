package com.ElectricityBillSystem;

import java.util.*;

public class Menu {

	public static void main(String[] args) {
		boolean flag=true;
		while(flag) 
		{
			System.out.println("-----------------------------------");
			System.out.println("|   1 - New Customer              |");
			System.out.println("|   2 - Modify Customer           |");
			System.out.println("|   3 - Delete Customer           |");
			System.out.println("|   4 - Show Particular Customer  |");
			System.out.println("|   5 - Show All Customers        |");
			System.out.println("|   6 - Generate New Bill         |");
			System.out.println("|   7 - Update Bill               |");
			System.out.println("|   8 - Delete Bill               |");
			System.out.println("|   9 - Show Particular Bill      |");
			System.out.println("|   10- Show All Bills            |");
			System.out.println("|   0 - Exit                      |");
			System.out.println("-----------------------------------");
			Scanner sc  = new Scanner(System.in);
			System.out.print("Enter Your Choice: ");
			
			if(sc.hasNextInt()) 
			{
				int ch = sc.nextInt();
				System.out.println("-----------------------------------");
				Consumer_Functions cf = new Consumer_Functions();
				Bill_Functions bf = new Bill_Functions();
				switch (ch) 
				{
				  case 1:
					  cf.createcon();
					  break;
				  case 2:
					  cf.updatecon();
					  break;
				  case 3:
					  cf.delcon();
					  break;
				  case 4:
					  cf.dispcon();
					  break;
				  case 5:
					  cf.dispallcon();
					  break;
				  case 6:
					  bf.createbill();
					  break;
				  case 7:
					  bf.updatebill();
					  break;
				  case 8:
					  bf.delbill();
					  break;
				  case 9:
					  bf.dispbill();
					  break;
				  case 10:
					  bf.dispallbill();
					  break;
				  case 0:
					  System.out.println("Exited, Thank You");
					  flag = false;
					  break;
				  default:
					  System.out.println("Inavlid Input");
				}
			}
			else {
				System.out.println("Invalid input");
				sc.nextLine();
			}
		}
	}
}
