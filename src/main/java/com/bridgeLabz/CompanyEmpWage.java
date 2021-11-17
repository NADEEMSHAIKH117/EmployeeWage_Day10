package com.bridgeLabz;

public class CompanyEmpWage 
{
	public final String company;
	public final int empRatePerHour;
	public final int maxWorkingDays;
	public final int maxWorkingHours;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company, int empRatePerHour,
			int maxWorkingDays, int maxWorkingHours)
	{
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.maxWorkingDays=maxWorkingDays;
		this.maxWorkingHours=maxWorkingHours;
		totalEmpWage=0;
	}
	
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage= totalEmpWage;
	}
	
	@Override
	public String toString()
	{
		return "Total Emp Wage for Company:" +company+" is: "+totalEmpWage;
	}
}
