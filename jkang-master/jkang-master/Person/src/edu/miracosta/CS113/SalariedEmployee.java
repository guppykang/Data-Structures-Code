package edu.miracosta.CS113;

public class SalariedEmployee extends Employee
{
	private double annualSalary;

	public SalariedEmployee() 
	{
		super();
		annualSalary = 0;
	}

	public SalariedEmployee(SalariedEmployee other) 
	{
		super(other);
		this.annualSalary = other.annualSalary;
		
	}

	public SalariedEmployee(String name, int socialSecurityNumber, int age, String gender, String address,
			int telephoneNumber, String department, int yearOfHire, String jobTitle, double annualSalary) 
	{
		super(name, socialSecurityNumber, age, gender, address, telephoneNumber, department, yearOfHire, jobTitle);
		this.annualSalary = annualSalary;
	} 
	
	public String toString()
	{
		return super.toString() + "\nAnnual Salary : " + annualSalary;
	}
	
	//getters and setters
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public boolean equals(SalariedEmployee other)
	{
		if(super.equals(other) == true && this.annualSalary == other.annualSalary)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
