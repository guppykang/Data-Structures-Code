package edu.miracosta.CS113;

public class HourlyEmployee extends Employee
{

	private double hourlyRate;
	private double hoursWorked;
	private double unionDues;
	
	public HourlyEmployee() 
	{
		super();
		hourlyRate = 0;
		hoursWorked = 0;
		unionDues = 0; 
	}

	public HourlyEmployee(HourlyEmployee other) 
	{
		super(other);
		this.setDepartment(other.getDepartment());
		this.setYearOfHire(other.getYearOfHire());
		this.setJobTitle(other.getJobTitle());
		
	}

	public HourlyEmployee(String name, int socialSecurityNumber, int age, String gender, String address,
			int telephoneNumber, String department, int yearOfHire, String jobTitle, double hourlyRate, 
			double hoursWorked, double unionDues)
	{
		super(name, socialSecurityNumber, age, gender, address, telephoneNumber, department, yearOfHire, jobTitle);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
		this.unionDues = unionDues;	}

	
	public HourlyEmployee(double hourlyRate, double hoursWorked, double unionDues) 
	{
		super();
		
	}	
	
	public String toString()
	{
		return super.toString() + "\nHourly Rate : " + hourlyRate + "\nHours Worked : " + hoursWorked + "\nUnion Dues : "
				+ unionDues; 

	}
	
	public boolean equals(HourlyEmployee other)
	{
		if(super.equals(other) == true && this.hourlyRate == other.hourlyRate && this.hoursWorked == other.hoursWorked &&
				this.unionDues == other.unionDues)
		{
			return true;
				
		}
		else
		{	
			return false;
		}
			
			
	}

	//geters and setters
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getUnionDues() {
		return unionDues;
	}

	public void setUnionDues(double unionDues) {
		this.unionDues = unionDues;
	}
	
}
