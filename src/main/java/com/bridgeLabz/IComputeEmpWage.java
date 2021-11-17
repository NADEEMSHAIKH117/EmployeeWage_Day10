package com.bridgeLabz;

public interface IComputeEmpWage 
{
	public void addCompanyEmpWage(String company, int empRatePerHour,
			int maxWorkingDays, int maxWorkingHours);
	public void computeEmpWage();
	public int computeEmpWage(CompanyEmpWage companyEmpWage);
	public int getTotalWage(String company);
}
