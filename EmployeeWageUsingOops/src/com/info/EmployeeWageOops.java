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
		return 1;
	}
}
