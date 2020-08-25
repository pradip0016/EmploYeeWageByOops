package com.info;

import java.util.ArrayList;
import java.util.HashMap;


public class EmployeeWageOops implements InEmployeeWageOops {
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	ArrayList<Integer> dailywage = new ArrayList<Integer>();
	private ArrayList<CompanyEmpWage> companyEmpwagearraylist;
	private HashMap<String, CompanyEmpWage> companyempwagemap;
	int daySalary;
	public static void main(String[] args) {
		EmployeeWageOops empWagebuilder = new EmployeeWageOops();
		empWagebuilder.addCompanyEmpwage("icici", 50, 2, 100);
	}
	public void dailywage() {
		dailywage.add(daySalary);
	}


	@Override
	public void addCompanyEmpwage(String company, int empratePerHr, int numberofWorkingDay, int max_Hr_per_Month) {
		CompanyEmpWage CompanyEmpWage = new CompanyEmpWage(company, empratePerHr, numberofWorkingDay, max_Hr_per_Month);
		companyEmpwagearraylist.add(CompanyEmpWage);
		companyempwagemap.put(company, CompanyEmpWage);
	}

	@Override
	public void computeEmpwage() {
		for (int i = 0; i < companyEmpwagearraylist.size(); i++) {
			CompanyEmpWage CompanyEmpWage = companyEmpwagearraylist.get(i);
			CompanyEmpWage.setTotalEmpwage(this.computeEmpwage(CompanyEmpWage));
			System.out.println(CompanyEmpWage);
		}
	}
	private int computeEmpwage(CompanyEmpWage companyEmpwage) {
		int rmpHrs = 0;
		int totalEmpHrs = 0;
		int EmpHrs = 0;
		int totalworkingDays = 0;
		while (totalEmpHrs <= companyEmpwage.max_Hr_per_Month && totalworkingDays < companyEmpwage.numberofWorkingDay) {
			totalworkingDays++;
			double empcheck = Math.floor(Math.random() * 10) % 3;
			switch ((int) empcheck) {
			case IS_FULL_TIME:
				EmpHrs = 8;
				break;
			case IS_PART_TIME:
				EmpHrs = 4;
				break;
			default:
				EmpHrs = 0;
			}
			int daysalary = EmpHrs * companyEmpwage.empratePerHr;
			totalEmpHrs += EmpHrs;
			System.out.println("TotalworkingDays : " + totalworkingDays + " / daily empHrs " + EmpHrs + " /totalEmpHrs "
					+ totalEmpHrs);
		}
		
		System.out.println(companyEmpwage.dailwage);
		
		return totalEmpHrs * companyEmpwage.empratePerHr;
	}

	public int getTotalEmpWage(String company) {
		return companyempwagemap.get(company).TotalEmpwage;
	}

	public EmployeeWageOops() {
		companyEmpwagearraylist = new ArrayList<CompanyEmpWage>();
		companyempwagemap = new HashMap<>();
	}

}
