package com.bridgeLabz;

import java.util.Scanner;

import java.util.*;

public class EmployeeWage 
{
	public final int IS_FULL_TIME = 1;
	public final int IS_PART_TIME = 2;
	int EMP_RATE_PER_HR [] = new int[10];
	int MAX_WORKING_DAYS [] = new int[10];
	int MAX_WORKING_HOURS [] = new int[10];
	int n=0;
	int totalWorkingHrs;
	int totalWorkingDays;
	int empHrs;
	int dailyWage;
	int totalWage[] = new int[10];
	int empCheck;
	
	public void working()
	{
		totalWorkingHrs=totalWorkingHrs+empHrs;
		totalWorkingDays++;
		if((totalWorkingHrs<=MAX_WORKING_HOURS[n]) && (totalWorkingDays<=MAX_WORKING_DAYS[n]))
		{
			System.out.println("Randome Check is: "+empCheck);
			System.out.println("Total Working Hours = "+totalWorkingHrs);
			System.out.println("Day = "+totalWorkingDays);
			dailyWage = empHrs*EMP_RATE_PER_HR[n];
			System.out.println("Employee Daily Wage is: "+dailyWage);
			totalWage[n] = totalWorkingHrs*EMP_RATE_PER_HR[n];
			System.out.println("Total Wage is: "+totalWage[n]);
			System.out.println(" ");
		}
	}
	public void limitations()
	{
		while((totalWorkingHrs<=MAX_WORKING_HOURS[n]) && (totalWorkingDays<=MAX_WORKING_DAYS[n]))
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
		System.out.println("1. Add Contact");
		System.out.println("2. Show Total Wages Of All The Companies ");
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
				obj1.n++;
				for(int i=obj1.n; i<=obj1.n; i++)
				{
					System.out.println("Give The Values For Company "+i+" :");
					System.out.println("Enter EMP_RATE_PER_HR :");
					int emp_rate_per_hr = sc.nextInt();
					System.out.println("Enter MAX_WORKING_DAYS :");
					int max_working_days = sc.nextInt();
					System.out.println("Enter MAX_WORKING_HOURS :");
					int max_working_hours = sc.nextInt();
					obj1.EMP_RATE_PER_HR [i] = emp_rate_per_hr;
					obj1.MAX_WORKING_DAYS [i] = max_working_days;
					obj1.MAX_WORKING_HOURS [i] = max_working_hours;
					obj1.limitations();
				}
				break;
			case 2:
				for(int j=1; j<=obj1.n; j++)
				{
					System.out.println("Total Wage Of Company "+j+" is :"+obj1.totalWage[j]);
				}
				break;
			default:
				System.out.println("Wrong InPut");
				break;				
			}
			System.out.println("0. Exit");
			System.out.println("1. Add Contact");
			System.out.println("2. Show Total Wages Of All The Companies ");
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
		}
		System.out.println("The Program Got Exit");
	}
}
