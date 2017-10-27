package edu.miracosta.CS113;

public class Employee extends Person
{
	private String department;
	private int yearOfHire; 
	private String jobTitle;
	
	


	public Employee() {
		super();
		this.department = "unknown";
		this.yearOfHire = 2017;
		this.jobTitle = "Employee";
	}




	public Employee(Employee other) 
	{
		this.setName(other.getName());
		this.setAddress(other.getAddress());
		this.setAge(other.getAge());
		this.setGender(other.getGender());
		this.setSocialSecurityNumber(other.getSocialSecurityNumber());
		this.setTelephoneNumber(other.getTelephoneNumber());
		this.setDepartment(other.getDepartment());
		this.setYearOfHire(other.getYearOfHire());
		this.setJobTitle(other.getJobTitle());
		this.setDepartment(other.getDepartment());
		this.setYearOfHire(other.getYearOfHire());
		this.setJobTitle(other.getJobTitle());
	}

	



	public Employee(String name, int socialSecurityNumber, int age, String gender, String address,
			int telephoneNumber, String department, int yearOfHire, String jobTitle) 
	{
		super(name, socialSecurityNumber, age, gender, address, telephoneNumber);
		this.department = department;
		this.yearOfHire = yearOfHire;
		this.jobTitle = jobTitle;
	}


	

	public String getDepartment() {
		return department;
	}




	public void setDepartment(String department) {
		this.department = department;
	}




	public int getYearOfHire() {
		return yearOfHire;
	}




	public void setYearOfHire(int yearOfHire) {
		this.yearOfHire = yearOfHire;
	}




	public String getJobTitle() {
		return jobTitle;
	}




	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}




	@Override
	public String toString() {
		return super.toString() + "\nDepartment : " + department + "\nYear of Hire : " 
										+ yearOfHire + "\nJob Title : " + jobTitle;
	} 
	
	
}
