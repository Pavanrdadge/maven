package com.ty.crud;

import java.util.Scanner;

import com.ty.service.AllLogicalData;

public class Driver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AllLogicalData logicalData = new AllLogicalData();

		Scanner scn = new Scanner(System.in);
		System.out.println("wel come to Students DataBase:");

		boolean flag = true;

		while (flag) {

			System.out.println("Please select Which operation You " + "want to Perform?");

			System.out.println("1.Adding new Student Data " + "\n");
			System.out.println("2.Update Student name Data " + "\n");
			System.out.println("3.Update Student marks Data " + "\n");
			System.out.println("4.Delete  Student Data " + "\n");
			System.out.println("5.Fetch Student Data: " + "\n");
			System.out.println("6.Fetch Student Data based on id: " + "\n");
			System.out.println("7.Exit ");
			int n = scn.nextInt();
			switch (n) {
			case 1: {
				logicalData.addData();
				System.out.println();
				System.out.println("thank you for Adding the data");
			}
				break;
				
			case 2:
			{
				logicalData.updateDataBasedOnName();
				System.out.println();
				System.out.println("Updation successfull: ");
			}
				break;
			case 3:
			{
			    logicalData.updateMarks();
			    System.out.println();
			    System.out.println("thank you for updating  the data");
			}
			break;
			case 4:
			{
				logicalData.deleteData();
				System.out.println();
				System.out.println("Thak You for Deleting the data");
			}
			break;
			
			case 5:
			{
				logicalData.displayData();
				System.out.println();
			}
			break;
			
			case 6:
			{
				logicalData.fetchBasedOnID();
				System.out.println();
			}
			break;
			case 7: {
				System.out.println("Do you Want to exit Y or N");
				String next = scn.next();

				if (next.equalsIgnoreCase("Y")) {
					flag = false;
					System.out.println("Thank you for using our Application");
				} else {
					flag = true;
				}
				break;
			}
			
			default:{
				System.out.println("Invalid number");
				System.out.println("Please enter valid number: ");
				
			}

			}

		}
	}
}
