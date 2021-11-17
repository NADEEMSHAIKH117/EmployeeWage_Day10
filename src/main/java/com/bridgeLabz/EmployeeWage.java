package com.bridgeLabz;

import java.util.*;

public class EmployeeWage implements IComputeEmpWage 
{
	public final int IS_FULL_TIME = 1;
	public final int IS_PART_TIME = 2;

	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private Map<String, CompanyEmpWage> companyToEmpWageMap;

	public EmployeeWage() 
	{
		companyEmpWageList = new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int maxWorkingDays, int maxWorkingHours) 
	{
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, maxWorkingDays, maxWorkingHours);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}

	public void computeEmpWage() 
	{
		for (int i = 0; i < companyEmpWageList.size(); i++) 
		{
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	@Override
	public int getTotalWage(String company)
	{
		return companyToEmpWageMap.get(company).totalEmpWage;
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage) 
	{
		// Variables
		int empHrs = 0;
		int totalWorkingHours = 0;
		int totalWorkingDays = 0;
		int dailyWage = 0;
		int totalWage = 0;

		// Computation
		System.out.println("#############################");
		System.out.println("Welcome to "+companyEmpWage.company);
		System.out.println("#############################");
		
		while ((totalWorkingHours <= companyEmpWage.maxWorkingHours)
				&& (totalWorkingDays <= companyEmpWage.maxWorkingDays)) 
		{
			int empCheck = (int) ((Math.random()) * 10) % 3;
			switch (empCheck) {
			case IS_FULL_TIME:
				empHrs = 8;
				totalWorkingHours = totalWorkingHours + empHrs;
				totalWorkingDays++;
				if ((totalWorkingHours <= companyEmpWage.maxWorkingHours)
						&& (totalWorkingDays <= companyEmpWage.maxWorkingDays)) 
				{
					System.out.println("Day#: " + totalWorkingDays);
					System.out.println(+empCheck);
					System.out.println("Full Time Employee");
					System.out.println("Total Working Hours = " + totalWorkingHours);
					dailyWage = empHrs * companyEmpWage.empRatePerHour;
					System.out.println("Employee Daily Wage is: " + dailyWage);
					totalWage = totalWorkingHours * companyEmpWage.empRatePerHour;
					System.out.println("Employee Total Wage is: " + totalWage);
				}
				break;

			case IS_PART_TIME:
				empHrs = 4;
				totalWorkingHours = totalWorkingHours + empHrs;
				totalWorkingDays++;
				if ((totalWorkingHours <= companyEmpWage.maxWorkingHours)
						&& (totalWorkingDays <= companyEmpWage.maxWorkingDays)) {
					System.out.println("Day#: " + totalWorkingDays);
					System.out.println(+empCheck);
					System.out.println("Part Time Employee");
					System.out.println("Total Working Hours = " + totalWorkingHours);
					dailyWage = empHrs * companyEmpWage.empRatePerHour;
					System.out.println("Employee Daily Wage is: " + dailyWage);
					totalWage = totalWorkingHours * companyEmpWage.empRatePerHour;
					System.out.println("Employee Total Wage is: " + totalWage);
				}
				break;

			default:
				empHrs = 0;
				totalWorkingHours = totalWorkingHours + empHrs;
				totalWorkingDays++;
				if ((totalWorkingHours <= companyEmpWage.maxWorkingHours)
						&& (totalWorkingDays <= companyEmpWage.maxWorkingDays)) {
					System.out.println("Day#: " + totalWorkingDays);
					System.out.println(+empCheck);
					System.out.println("Employee is Absent");
					System.out.println("Total Working Hours = " + totalWorkingHours);
					dailyWage = empHrs * companyEmpWage.empRatePerHour;
					System.out.println("Employee Daily Wage is: " + dailyWage);
					totalWage = totalWorkingHours * companyEmpWage.empRatePerHour;
					System.out.println("Employee Total Wage is: " + totalWage);
				}
				break;
			}
		}
		return totalWorkingHours * companyEmpWage.empRatePerHour;
	}

	public static void main(String[] args) {
		IComputeEmpWage employeeWage = new EmployeeWage();
		employeeWage.addCompanyEmpWage("Reliance", 20, 20, 100);
		employeeWage.addCompanyEmpWage("Heritage", 21, 22, 110);
		employeeWage.addCompanyEmpWage("Vishal Mart", 22, 24, 120);
		employeeWage.computeEmpWage();
		System.out.println("#############################");
		System.out.println("Total Wage for Reliance Company is: " + employeeWage.getTotalWage("Reliance"));
	}
}