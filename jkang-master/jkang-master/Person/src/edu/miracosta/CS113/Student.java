package edu.miracosta.CS113;

public class Student extends Person 
{

	private double gradePointAverage; 
	private String major; 
	private int yearOfGraduation;
	
	
	
	public Student() 
	{
		super();
		gradePointAverage = 4.0;
		major = "Undecided";
		yearOfGraduation = 2017;
		
	}

	

	public Student(String name, int socialSecurityNumber, int age, String gender, String address, int telephoneNumber
			       , double gradePointAverage, String major, int yearOfGraduation) 
	{
		super(name, socialSecurityNumber, age, gender, address, telephoneNumber);
		this.gradePointAverage = gradePointAverage; 
		this.major = major;
		this.yearOfGraduation = yearOfGraduation;
	}
	
	public Student(Student other) {
		this.setName(other.getName());
		this.setAddress(other.getAddress());
		this.setAge(other.getAge());
		this.setGender(other.getGender());
		this.setGradePointAverage(other.getGradePointAverage());
		this.setMajor(other.getMajor());
		this.setSocialSecurityNumber(other.getSocialSecurityNumber());
		this.setYearOfGraduation(other.getYearOfGraduation());
		this.setTelephoneNumber(other.getTelephoneNumber());
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nGrade Point Average : " + gradePointAverage + "\nMajor : "  + major + "\nYear of Graduation " + 
				yearOfGraduation; 
	}
	
	//getters and setters
	public double getGradePointAverage() 
	{
		return gradePointAverage;
	}
	public void setGradePointAverage(double gradePointAverage) 
	{
		this.gradePointAverage = gradePointAverage;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public int getYearOfGraduation() 
	{
		return yearOfGraduation;
	}
	public void setYearOfGraduation(int yearOfGraduation)
	{
		this.yearOfGraduation = yearOfGraduation;
	}
	
	public boolean equals(Student other)
	{
		if(this.getName().equals(other.getName()) && this.getSocialSecurityNumber() == other.getSocialSecurityNumber() &&
				this.getAge() == other.getAge() && this.getGender().equals(other.getGender()) && 
				this.getAddress().equals(other.getAddress()) && this.getTelephoneNumber() == other.getTelephoneNumber() &&
				this.getGradePointAverage() == other.getGradePointAverage() && this.getMajor().equals(other.getMajor())&& 
				this.getYearOfGraduation() == other.getYearOfGraduation())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
