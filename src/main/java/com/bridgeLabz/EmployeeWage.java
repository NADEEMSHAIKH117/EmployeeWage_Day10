package com.bridgeLabz;

import java.util.Scanner;

public class EmployeeWage {
	public final int IS_FULL_TIME = 1;
	public final int IS_PART_TIME = 2;
	int EMP_RATE_PER_HR ;
	int MAX_WORKING_DAYS ;
	int MAX_WORKING_HOURS ;
	int totalWorkingHrs;
	int totalWorkingDays;
	int empHrs;
	int dailyWage;
	int totalWage;
	int empCheck;
	
	public void working()
	{
		totalWorkingHrs=totalWorkingHrs+empHrs;
		totalWorkingDays++;
		if((totalWorkingHrs<=MAX_WORKING_HOURS) && (totalWorkingDays<=MAX_WORKING_DAYS))
		{
			System.out.println("Randome Check is: "+empCheck);
			System.out.println("Total Working Hours = "+totalWorkingHrs);
			System.out.println("Day = "+totalWorkingDays);
			dailyWage = empHrs*EMP_RATE_PER_HR;
			System.out.println("Employee Daily Wage is: "+dailyWage);
			totalWage = totalWorkingHrs*EMP_RATE_PER_HR;
			System.out.println("Total Wage is: "+totalWage);
			System.out.println(" ");
		}
	}
	public void limitations()
	{
		while((totalWorkingHrs<=MAX_WORKING_HOURS) && (totalWorkingDays<=MAX_WORKING_DAYS))
		{
			
			empCheck =(int) ((Math.random())*10)%3;
			switch(empCheck)
			{
			case IS_FULL_TIME:
				empHrs = 8;
				working();
				break;
				
			case IS_PART_TIME:
				empHrs = 4;
				working();
				break;
				
			default:
				empHrs=0;
				working();
				break;
				
			}
		}
	}
	
	public static void main(String[] args) 
	{
		EmployeeWage obj1=new EmployeeWage();
		System.out.println("0. Exit");
		System.out.println("1. Add Contact\n");
		System.out.println("Enter Your Choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		while(choice!=0)
		{
			switch(choice)
			{
			case 1:
				obj1.totalWorkingHrs = 0;
				obj1.totalWorkingDays = 0;
				obj1.empHrs = 0;
					System.out.println("Give The Values For Company :\n");
					System.out.println("Enter Employe Rate per Hour :");
					obj1.EMP_RATE_PER_HR = sc.nextInt();
					System.out.println("Enter Maximum Working Day :");
					obj1.MAX_WORKING_DAYS = sc.nextInt();
					System.out.println("Enter Maximum Working Hours :");
					obj1.MAX_WORKING_HOURS = sc.nextInt();
					obj1.limitations();
				break;
			default:
				System.out.println("Wrong InPut");
				break;				
			}
			System.out.println("Press 0 To Exit");
			System.out.println("Press 1 To Add Contact");
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
		}
		System.out.println("Exit");
	}
}
